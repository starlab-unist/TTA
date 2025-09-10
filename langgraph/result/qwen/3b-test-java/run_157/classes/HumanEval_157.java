public class HumanEval_157 {
    public static boolean isRightAngled(int x, int y, int z) {
        int[] sidesSquared = new int[]{x * x, y * y, z * z};
        java.util.Arrays.sort(sidesSquared);
        return sidesSquared[0] + sidesSquared[1] == sidesSquared[2];
    }
}