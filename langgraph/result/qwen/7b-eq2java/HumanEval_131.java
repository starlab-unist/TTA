public class HumanEval_131 {
    public static int calculateOddDigitProduct(int number) {
        int result = 1;
        int oddDigitsFound = 0;
        String numberStr = Integer.toString(number);
        int index = 0;

        while (index < numberStr.length()) {
            char currentChar = numberStr.charAt(index);
            int currentDigit = Character.getNumericValue(currentChar);
            if (currentDigit % 2 != 0) {
                result *= currentDigit;
                oddDigitsFound++;
            }
            index++;
        }

        return oddDigitsFound > 0 ? result : 0;
    }
}