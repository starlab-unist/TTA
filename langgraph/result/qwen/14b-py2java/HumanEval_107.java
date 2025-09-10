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

    private static boolean isPalindrome(int n) {
        String str = Integer.toString(n);
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}