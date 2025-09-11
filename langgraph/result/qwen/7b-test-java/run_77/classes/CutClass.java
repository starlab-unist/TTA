public boolean isCube(int a) {
    int cubeRoot = (int) Math.round(Math.cbrt(a));
    return cubeRoot * cubeRoot * cubeRoot == a;
}