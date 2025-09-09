public class HumanEval_107 {

    public static int[] evenOddPalindrome(int n) {
        int evenPalindromeCount = 0;
        int oddPalindromeCount = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1 && isPalindrome(i)) {
                oddPalindromeCount++;
            } else if (i % 2 == 0 && isPalindrome(i)) {
                evenPalindromeCount++;
            }
        }

        return new int[]{evenPalindromeCount, oddPalindromeCount};
    }

    private static boolean isPalindrome(int number) {
        String numStr = Integer.toString(number);
        String reversedStr = new StringBuilder(numStr).reverse().toString();
        return numStr.equals(reversedStr);
    }
}