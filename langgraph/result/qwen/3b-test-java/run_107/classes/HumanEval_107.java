public class HumanEval_107 {

    public static int[] countEvenOddPalindromes(int limit) {
        int evenCount = 0;
        int oddCount = 0;

        int currentNumber = 1;
        while (currentNumber <= limit) {
            if (currentNumber % 2 != 0 && isPalindrome(currentNumber)) {
                oddCount++;
            } else if (currentNumber % 2 == 0 && isPalindrome(currentNumber)) {
                evenCount++;
            }
            currentNumber++;
        }

        return new int[]{evenCount, oddCount};
    }

    private static boolean isPalindrome(int number) {
        String strNumber = Integer.toString(number);
        String reversedStrNumber = new StringBuilder(strNumber).reverse().toString();
        return strNumber.equals(reversedStrNumber);
    }
}