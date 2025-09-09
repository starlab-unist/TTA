public class HumanEval_131 {
    public int calculateOddDigitProduct(int number) {
        int result = 1;
        int oddDigitsFound = 0;
        String numberStr = Integer.toString(number);
        
        for (int i = 0; i < numberStr.length(); i++) {
            int currentDigit = Character.getNumericValue(numberStr.charAt(i));
            if (currentDigit % 2 != 0) {
                result *= currentDigit;
                oddDigitsFound++;
            }
        }
        
        return oddDigitsFound > 0 ? result : 0;
    }
}