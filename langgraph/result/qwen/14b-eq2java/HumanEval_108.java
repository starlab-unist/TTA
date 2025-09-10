public class HumanEval_108 {
    public static int tally_positive_digit_sums(int[] numbers) {
        int positive_sums_count = 0;

        for (int num : numbers) {
            if (compute_digit_sum(num) > 0) {
                positive_sums_count++;
            }
        }

        return positive_sums_count;
    }

    private static int compute_digit_sum(int number) {
        int sign = (number < 0) ? -1 : 1;
        int absolute_value = Math.abs(number);
        String digitStr = Integer.toString(absolute_value);
        int digitSum = 0;

        for (int i = 0; i < digitStr.length(); i++) {
            int digit = Character.getNumericValue(digitStr.charAt(i));
            if (i == 0) {
                digit *= sign;
            }
            digitSum += digit;
        }

        return digitSum;
    }
}