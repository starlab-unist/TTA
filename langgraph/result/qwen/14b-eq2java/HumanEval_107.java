public class HumanEval_107 {
    public static int[] countEvenOddPalindromes(int limit) {
        int evenCount = 0;
        int oddCount = 0;

        int currentNumber = 1;
        while (currentNumber <= limit) {
            if (currentNumber % 2 == 1 && checkPalindrome(currentNumber)) {
                oddCount++;
            } else if (currentNumber % 2 == 0 && checkPalindrome(currentNumber)) {
                evenCount++;
            }
            currentNumber++;
        }

        return new int[]{evenCount, oddCount};
    }

    private static boolean checkPalindrome(int number) {
        String str = Integer.toString(number);
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}