public class HumanEval_157 {
    public static boolean is_right_angled(double x, double y, double z) {
        double[] sidesSquared = {x * x, y * y, z * z};
        java.util.Arrays.sort(sidesSquared);
        return sidesSquared[0] + sidesSquared[1] == sidesSquared[2];
    }
}