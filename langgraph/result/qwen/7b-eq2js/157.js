function isRightAngled(a, b, c) {
    let sidesSquared = [a**2, b**2, c**2];
    sidesSquared.sort((m, n) => m - n);
    return sidesSquared[0] + sidesSquared[1] === sidesSquared[2];
}