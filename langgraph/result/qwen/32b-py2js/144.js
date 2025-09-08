function simplify(x, n) {
    const [a, b] = x.split("/");
    const [c, d] = n.split("/");
    const numerator = parseInt(a) * parseInt(c);
    const denom = parseInt(b) * parseInt(d);
    return numerator / denom === Math.floor(numerator / denom);
}