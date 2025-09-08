function isRightAngled(x, y, z) {
    const sidesSquared = [x * x, y * y, z * z];
    sidesSquared.sort((a, b) => a - b);
    return sidesSquared[0] + sidesSquared[1] === sidesSquared[2];
}