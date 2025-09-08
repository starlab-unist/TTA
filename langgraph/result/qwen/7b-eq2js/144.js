function checkFractionSimplification(x, n) {
    const [a, b] = x.split('/').map(Number);
    const [c, d] = n.split('/').map(Number);
    const numerator = a * c;
    const denom = b * d;
    return numerator % denom === 0;
}