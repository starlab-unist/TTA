public class HumanEval_146 {

    public static int specialFilter(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num > 10) {
                int[] oddDigits = {1, 3, 5, 7, 9};
                String numberAsString = Integer.toString(num);
                int firstDigit = Character.digit(numberAsString.charAt(0), 10);
                int lastDigit = Character.digit(numberAsString.charAt(numberAsString.length() - 1), 10);
                boolean isFirstDigitOdd = false;
                boolean isLastDigitOdd = false;
                for (int digit : oddDigits) {
                    if (digit == firstDigit) {
                        isFirstDigitOdd = true;
                    }
                    if (digit == lastDigit) {
                        isLastDigitOdd = true;
                    }
                    if (isFirstDigitOdd && isLastDigitOdd) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }

}