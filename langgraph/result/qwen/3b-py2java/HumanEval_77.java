public class HumanEval_77 {

    public static boolean isCube(int a) {
        a = Math.abs(a);
        int cubeRoot = (int) Math.round(Math.pow(a, 1.0 / 3.0));
        return cubeRoot * cubeRoot * cubeRoot == a;
    }
}