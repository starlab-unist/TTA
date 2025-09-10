public class HumanEval_155 {
    public static int[] evenOddCount(int num) {
        int evenCount = 0;
        int oddCount = 0;
        String numStr = Integer.toString(Math.abs(num));
        for (char c : numStr.toCharArray()) {
            int digit = Character.getNumericValue(c);
            if (digit % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        return new int[]{evenCount, oddCount};
    }
}