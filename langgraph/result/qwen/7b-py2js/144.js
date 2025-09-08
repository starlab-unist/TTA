function simplify(x, n) {
    let [a, b] = x.split("/");
    let [c, d] = n.split("/");
    let numerator = parseInt(a) * parseInt(c);
    let denom = parseInt(b) * parseInt(d);
    if (numerator / denom === Math.floor(numerator / denom)) {
        return true;
    }
    return false;
}