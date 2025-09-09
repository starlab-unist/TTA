class HumanEval_10 {

    /**
     * Test if given string is a palindrome
     */
    public static boolean isPalindrome(String string) {
        return string.equals(new StringBuilder(string).reverse().toString());
    }

    public static String makePalindrome(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        }

        int beginningOfSuffix = 0;

        while (!isPalindrome(string.substring(beginningOfSuffix))) {
            beginningOfSuffix++;
        }

        return string + new StringBuilder(string.substring(0, beginningOfSuffix)).reverse().toString();
    }
}