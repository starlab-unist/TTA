public class HumanEval_108 {

    public static int countNums(int[] arr) {
        return (int) Arrays.stream(arr)
                .mapToInt(HumanEval_108::digitsSum)
                .filter(i -> i > 0)
                .count();
    }

    private static int digitsSum(int n) {
        boolean neg = n < 0;
        n = Math.abs(n);
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return neg ? -sum : sum;
    }
}