function isCube(a) {
    a = Math.abs(a);
    const cubeRoot = Math.round(Math.pow(a, 1 / 3));
    return Math.pow(cubeRoot, 3) === a;
}