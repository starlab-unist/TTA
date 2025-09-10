public class HumanEval_155 {
    public static int[] tallyEvenOddDigits(int number) {
        int evenTally = 0;
        int oddTally = 0;
        int index = 0;
        String numStr = Integer.toString(Math.abs(number));
        
        while (index < numStr.length()) {
            int digit = Character.getNumericValue(numStr.charAt(index));
            if (digit % 2 == 0) {
                evenTally += 1;
            } else {
                oddTally += 1;
            }
            index += 1;
        }
        
        return new int[]{evenTally, oddTally};
    }
}