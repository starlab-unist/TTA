function checkPerfectCube(number) {
    number = Math.abs(number);
    const cubeRoot = Math.round(Math.pow(number, 1/3));
    return Math.pow(cubeRoot, 3) === number;
}