function poly(xs, x) {
    return xs.reduce((sum, coeff, i) => sum + coeff * Math.pow(x, i), 0);
}

function findZero(xs) {
    let begin = -1.0;
    let end = 1.0;
    while (poly(xs, begin) * poly(xs, end) > 0) {
        begin *= 2.0;
        end *= 2.0;
    }
    while (end - begin > 1e-10) {
        const center = (begin + end) / 2.0;
        if (poly(xs, center) * poly(xs, begin) > 0) {
            begin = center;
        } else {
            end = center;
        }
    }
    return begin;
}