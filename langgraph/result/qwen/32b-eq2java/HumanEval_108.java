public class HumanEval_108 {

    public int tallyPositiveDigitSums(int[] numbers) {
        int positiveSumsCount = 0;
        for (int num : numbers) {
            if (computeDigitSum(num) > 0) {
                positiveSumsCount++;
            }
        }
        return positiveSumsCount;
    }

    private int computeDigitSum(int number) {
        int sign = number < 0 ? -1 : 1;
        int absoluteValue = Math.abs(number);
        String numberStr = Integer.toString(absoluteValue);
        int[] digitList = new int[numberStr.length()];

        for (int i = 0; i < numberStr.length(); i++) {
            digitList[i] = Character.getNumericValue(numberStr.charAt(i));
        }
        digitList[0] *= sign;

        int sum = 0;
        for (int digit : digitList) {
            sum += digit;
        }
        return sum;
    }
}