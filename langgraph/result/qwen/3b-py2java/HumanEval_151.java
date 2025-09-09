public class HumanEval_151 {

    public static int doubleTheDifference(int[] lst) {
        int sum = 0;
        for (int i : lst) {
            if (i > 0 && i % 2 != 0 && !str(i).contains(".")) {
                sum += i * i;
            }
        }
        return sum;
    }

    private static String str(int i) {
        return Integer.toString(i);
    }
}