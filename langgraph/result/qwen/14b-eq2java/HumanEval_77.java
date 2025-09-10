public class HumanEval_77 {
    public static boolean checkPerfectCube(int number) {
        number = Math.abs(number);
        int cubeRoot = (int) Math.round(Math.cbrt(number));
        return cubeRoot * cubeRoot * cubeRoot == number;
    }
}