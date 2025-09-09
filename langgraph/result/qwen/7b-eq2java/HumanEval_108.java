public class HumanEval_108 {
    public static int tallyPositiveDigitSums(int[] numbers) {
        int positiveSumsCount = 0;
        for (int num : numbers) {
            if (computeDigitSum(num) > 0) {
                positiveSumsCount++;
            }
        }
        return positiveSumsCount;
    }

    private static int computeDigitSum(int number) {
        int sign = number < 0 ? -1 : 1;
        int absoluteValue = Math.abs(number);
        String numberStr = Integer.toString(absoluteValue);
        int digitSum = 0;
        for (int i = 0; i < numberStr.length(); i++) {
            int digit = Character.digit(numberStr.charAt(i), 10);
            if (i == 0) {
                digit *= sign;
            }
            digitSum += digit;
        }
        return digitSum;
    }
}