public class HumanEval_77 {

    public static boolean checkPerfectCube(int number) {
        number = Math.abs(number);
        int cubeRoot = (int) Math.round(Math.pow(number, 1.0 / 3.0));
        return cubeRoot * cubeRoot * cubeRoot == number;
    }
}