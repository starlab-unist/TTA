function isCube(a) {
    a = Math.abs(a);
    let cubeRoot = Math.round(Math.pow(a, 1/3));
    return cubeRoot ** 3 === a;
}