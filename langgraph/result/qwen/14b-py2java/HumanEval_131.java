public class HumanEval_131 {
    public static int digits(int n) {
        int product = 1;
        int oddCount = 0;
        String numberStr = Integer.toString(n);
        
        for (char digitChar : numberStr.toCharArray()) {
            int intDigit = Character.getNumericValue(digitChar);
            if (intDigit % 2 == 1) {
                product *= intDigit;
                oddCount++;
            }
        }
        
        if (oddCount == 0) {
            return 0;
        } else {
            return product;
        }
    }
}