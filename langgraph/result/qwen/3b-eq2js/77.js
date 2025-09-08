function checkPerfectCube(number) {
    number = Math.abs(number);
    let cubeRoot = Math.round(Math.pow(number, 1/3));
    return Math.pow(cubeRoot, 3) === number;
}