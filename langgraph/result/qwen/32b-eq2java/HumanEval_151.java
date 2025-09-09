public class HumanEval_151 {
    public static int calculateModifiedSum(int[] numbers) {
        int total = 0;
        for (int num : numbers) {
            if (num > 0 && num % 2 != 0) {
                total += num * num;
            }
        }
        return total;
    }
}