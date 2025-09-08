function checkPerfectCube(number) {
    number = Math.abs(number);
    let cubeRoot = Math.round(Math.cbrt(number));
    return cubeRoot ** 3 === number;
}