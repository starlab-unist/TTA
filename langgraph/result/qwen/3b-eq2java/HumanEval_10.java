public class HumanEval_10 {

    public static boolean checkPalindrome(String sequence) {
        // Determine if the provided sequence is a palindrome
        return sequence.equals(new StringBuilder(sequence).reverse().toString());
    }

    public static String constructPalindrome(String inputStr) {
        if (inputStr == null || inputStr.isEmpty()) {
            return "";
        }

        int suffixStartIndex = 0;

        while (!checkPalindrome(inputStr.substring(suffixStartIndex))) {
            suffixStartIndex++;
        }

        return inputStr + new StringBuilder(inputStr.substring(0, suffixStartIndex)).reverse().toString();
    }
}