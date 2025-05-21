const fs = require("fs");
const path = require("path");
const { addHook } = require("pirates");
const espree = require("espree");
const estraverse = require("estraverse");
const { performance } = require("perf_hooks");

// Normalize whitespace for matching function source
function normalizeFunctionSource(source) {
  return source.replace(/\s+/g, " ").replace(/(?<!\w)\s+|\s+(?!\w)/g, "");
}

/**
 * Parse code and record only function locations.
 * Skips files with shebang or in node_modules.
 */
function findFunctionLocations(code, locations, filename) {
  if (!filename || code.startsWith("#!")) return code;
  performance.mark("location-extraction-start");
  try {
    const ast = espree.parse(code, { ecmaVersion: 2020, loc: true, range: true });
    estraverse.traverse(ast, {
      enter(node) {
        if ((node.type === "FunctionDeclaration" ||
             node.type === "FunctionExpression" ||
             node.type === "ArrowFunctionExpression") &&
            node.range && node.loc) {
          const fnSource = normalizeFunctionSource(
            code.slice(node.range[0], node.range[1])
          );
          locations.set(fnSource, {
            // Save absolute path instead of relative
            file: path.resolve(filename),
            startLine: node.loc.start.line,
            endLine: node.loc.end.line,
          });
        }
      }
    });
  } catch (e) {
    console.warn("location-extraction failed for", filename, e.message);
  }
  performance.measure("location-extraction", "location-extraction-start");
  return code;
}

// Recursively scan directories for .js source files, skipping node_modules
function analyzeSourceDirectory(dirPath, locations) {
  if (!fs.existsSync(dirPath)) return;
  const stat = fs.statSync(dirPath);
  if (stat.isDirectory()) {
    if (path.basename(dirPath) === 'node_modules') return;
    for (const entry of fs.readdirSync(dirPath)) {
      analyzeSourceDirectory(path.join(dirPath, entry), locations);
    }
  } else if (stat.isFile() && dirPath.endsWith('.js')) {
    const code = fs.readFileSync(dirPath, 'utf8');
    findFunctionLocations(code, locations, dirPath);
  }
}

// Extend property access path
function extend(accessPath, component) {
  if (component === 'default' && !accessPath.includes('.')) return accessPath;
  if (/^[a-zA-Z_$][\w$]*$/.test(component)) {
    return `${accessPath}.${component}`;
  }
  if (/^\d+$/.test(component)) {
    return `${accessPath}[${component}]`;
  }
  return `${accessPath}[${JSON.stringify(component)}]`;
}

// API container
function API(elements) { this.elements = elements || new Map(); }
API.prototype.set = function(pathStr, desc) { this.elements.set(pathStr, desc); };
API.prototype.get = function(pathStr) { return this.elements.get(pathStr); };
API.prototype.getFunctions = function*(pkgName) {
  for (const [pathStr, desc] of this.elements) {
    if (desc.type === 'function') yield new APIFunction(pathStr, desc, pkgName);
  }
};
API.prototype.toJSON = function() { return [...this.elements]; };
API.fromJSON = function(json) { return new API(new Map(json)); };

// APIFunction wrapper
function APIFunction(accessPath, descriptor, pkgName) {
  this.accessPath = accessPath;
  this.descriptor = descriptor;
  this.packageName = pkgName;
}
Object.defineProperty(APIFunction.prototype, 'signature', {
  get() {
    const d = this.descriptor;
    return `${d.isConstructor ? 'class ' : ''}` +
           `${this.accessPath}` +
           `${d.signature}` +
           `${d.isAsync ? ' async' : ''}`;
  }
});
APIFunction.prototype.toJSON = function() {
  return {
    accessPath: this.accessPath,
    descriptor: this.descriptor,
    packageName: this.packageName
  };
};
APIFunction.fromJSON = function(o) {
  return new APIFunction(o.accessPath, o.descriptor, o.packageName);
};

// Helpers for inspecting functions
const funcToString = Function.prototype.toString;
function isConstructor(fn) { return funcToString.call(fn).startsWith('class '); }
function getSignature(fn) {
  const src = funcToString.call(fn);
  if (isConstructor(fn)) {
    const mm = src.match(/constructor\s*\(([^)]*)\)/);
    return mm ? `(${mm[1]})` : '()';
  }
  const o = src.indexOf('('), c = src.indexOf(')');
  if (o < 0 || c < 0) return '()';
  const inside = src.slice(o + 1, c).split(',').map(s => s.trim()).filter(Boolean);
  if (inside.length >= fn.length) {
    return `(${inside.join(', ')})`;
  } else {
    return `(${Array.from({ length: fn.length }, (_, i) => `arg${i+1}`).join(', ')})`;
  }
}

function describe(val, locations) {
  const t = typeof val;
  if (['bigint','boolean','number','string','symbol','undefined'].includes(t)) return { type: t };
  if (val === null) return { type: 'null' };
  if (Array.isArray(val)) return { type: 'array' };
  if (t === 'object') return { type: 'object' };
  const src = funcToString.call(val), norm = normalizeFunctionSource(src);
  const desc = {
    type: 'function',
    signature: getSignature(val),
    implementation: src,
    isConstructor: isConstructor(val),
    isAsync: src.trim().startsWith('async ')
  };
  if (locations.has(norm)) desc.location = locations.get(norm);
  return desc;
}

function getProperties(obj) {
  const keys = new Set();
  for (let k in obj) keys.add(k);
  const descs = Object.getOwnPropertyDescriptors(obj);
  for (const k in descs) if ('value' in descs[k]) keys.add(k);
  return keys;
}

function exploreExports(pkgName, pkgExports, locations) {
  const api = new API();
  const seen = new Set();
  function walk(pathStr, val) {
    if (seen.has(val)) return;
    seen.add(val);
    const d = describe(val, locations);
    if (!['object','null'].includes(d.type)) api.set(pathStr, d);
    if (['object','array','function'].includes(d.type)) {
      for (const prop of getProperties(val)) {
        if (prop.startsWith('_') || ['super','super_','constructor'].includes(prop)) continue;
        if (d.type === 'function' && ['arguments','caller','length','name'].includes(prop)) continue;
        if (d.type === 'array' && prop === 'length') continue;
        walk(extend(pathStr, prop), val[prop]);
      }
    }
  }
  walk(pkgName, pkgExports);
  return api;
}

function exploreAPI(pkgPath) {
  performance.mark('api-exploration-start');
  const pkgAbs = path.resolve(pkgPath);
  const pkgJson = JSON.parse(fs.readFileSync(path.join(pkgPath, 'package.json'), 'utf8'));
  const pkgName = pkgJson.name;
  const locations = new Map();

  // Pre-scan source files
  analyzeSourceDirectory(pkgAbs, locations);

  // Hook into require: correct callback signature, skip node_modules
  const revert = addHook(
    (code, filename) => findFunctionLocations(code, locations, filename),
    {
      exts: ['.js'],
      matcher: filename =>
        filename.startsWith(pkgAbs) && !filename.includes(`${path.sep}node_modules${path.sep}`)
    }
  );

  const pkgExports = require(pkgPath);
  revert();

  const api = exploreExports(pkgName, pkgExports, locations);
  performance.measure('api-exploration', 'api-exploration-start');
  return api;
}

if (require.main === module) {
  const pkgPath = process.argv[2];
  const out = process.argv[3] || 'api.json';
  if (!pkgPath) {
    console.error('Usage: node exploreAPI.js <pkgPath> [output]');
    process.exit(1);
  }
  const api = exploreAPI(pkgPath);
  fs.writeFileSync(out, JSON.stringify(api.toJSON(), null, 2), 'utf8');
  console.log(`API description saved to ${out}`);
}

