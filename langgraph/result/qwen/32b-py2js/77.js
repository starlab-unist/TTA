function isCube(a) {
    a = Math.abs(a);
    const cubeRoot = Math.round(Math.cbrt(a));
    return cubeRoot ** 3 === a;
}