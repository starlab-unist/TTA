public class HumanEval_146 {
    public static int specialFilter(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num > 10) {
                int[] oddDigits = {1, 3, 5, 7, 9};
                String numberAsString = Integer.toString(num);
                int firstDigit = Character.getNumericValue(numberAsString.charAt(0));
                int lastDigit = Character.getNumericValue(numberAsString.charAt(numberAsString.length() - 1));
                boolean isFirstDigitOdd = false;
                boolean isLastDigitOdd = false;
                
                for (int oddDigit : oddDigits) {
                    if (firstDigit == oddDigit) {
                        isFirstDigitOdd = true;
                    }
                    if (lastDigit == oddDigit) {
                        isLastDigitOdd = true;
                    }
                }
                
                if (isFirstDigitOdd && isLastDigitOdd) {
                    count++;
                }
            }
        }
        return count;
    }
}