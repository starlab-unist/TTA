public class HumanEval_151 {
    public static int doubleTheDifference(int[] lst) {
        int sum = 0;
        for (int i : lst) {
            if (i > 0 && i % 2 != 0) {
                sum += i * i;
            }
        }
        return sum;
    }
}