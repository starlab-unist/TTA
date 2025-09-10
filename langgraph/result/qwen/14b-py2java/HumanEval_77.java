public class HumanEval_77 {
    public static boolean iscube(int a) {
        a = Math.abs(a);
        int cubeRoot = Math.round(Math.cbrt(a));
        return cubeRoot * cubeRoot * cubeRoot == a;
    }
}