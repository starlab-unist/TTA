function isRightAngled(x, y, z) {
    const sidesSquared = [x**2, y**2, z**2];
    sidesSquared.sort((a, b) => a - b);
    return sidesSquared[0] + sidesSquared[1] === sidesSquared[2];
}