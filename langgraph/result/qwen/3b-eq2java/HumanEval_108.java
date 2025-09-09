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
        int[] digitList = new int[Integer.toString(absoluteValue).length()];

        for (int i = 0; i < digitList.length; i++) {
            digitList[i] = Character.getNumericValue(Integer.toString(absoluteValue).charAt(i));
        }

        digitList[0] *= sign;
        return Arrays.stream(digitList).sum();
    }
}