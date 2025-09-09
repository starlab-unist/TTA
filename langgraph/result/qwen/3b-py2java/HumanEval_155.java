public class HumanEval_155 {

    public static int[] evenOddCount(int num) {
        int evenCount = 0;
        int oddCount = 0;
        String absNumStr = Integer.toString(Math.abs(num));

        for (int i = 0; i < absNumStr.length(); i++) {
            int digit = Character.getNumericValue(absNumStr.charAt(i));
            if (digit % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        return new int[]{evenCount, oddCount};
    }
}