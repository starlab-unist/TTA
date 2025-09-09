public class HumanEval_77 {
    public static boolean isCube(int a) {
        a = Math.abs(a);
        int cubeRoot = (int) Math.round(Math.cbrt(a));
        return cubeRoot * cubeRoot * cubeRoot == a;
    }
}