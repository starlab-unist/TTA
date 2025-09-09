public class HumanEval_155 {
    public static int[] tallyEvenOddDigits(int number) {
        int evenCount = 0;
        int oddCount = 0;
        int index = 0;
        String numStr = Integer.toString(Math.abs(number));
        
        while (index < numStr.length()) {
            int digit = Character.digit(numStr.charAt(index), 10);
            if (digit % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
            index++;
        }
        
        return new int[]{evenCount, oddCount};
    }
}