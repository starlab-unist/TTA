public class HumanEval_155 {

    public static int[] tallyEvenOddDigits(int number) {
        int evenTally = 0;
        int oddTally = 0;
        String numStr = Math.abs(number) + ""; // Convert to string

        int index = 0;
        while (index < numStr.length()) {
            char digitChar = numStr.charAt(index);
            int digit = Character.getNumericValue(digitChar);
            if (digit % 2 == 0) {
                evenTally++;
            } else {
                oddTally++;
            }
            index++;
        }

        return new int[]{evenTally, oddTally};
    }
}