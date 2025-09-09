public class HumanEval_77 {
    public boolean checkPerfectCube(int number) {
        number = Math.abs(number);
        int cubeRoot = Math.round(Math.cbrt(number));
        return cubeRoot * cubeRoot * cubeRoot == number;
    }
}