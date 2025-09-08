function isCube(a) {
    a = Math.abs(a);
    return Math.pow(Math.round(Math.cbrt(a)), 3) === a;
}