function simplify(x, n) {
    const [a, b] = x.split("/");
    const [c, d] = n.split("/");
    const numerator = parseInt(a) * parseInt(c);
    const denom = parseInt(b) * parseInt(d);
    if (numerator / denom === parseInt(numerator / denom)) {
        return true;
    }
    return false;
}

console.log(simplify("2/3", "4/6")); // Output: true