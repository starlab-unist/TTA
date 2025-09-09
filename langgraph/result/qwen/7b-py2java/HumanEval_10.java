public class HumanEval_10 {

    public static boolean isPalindrome(String string) {
        """ Test if given string is a palindrome """
        int left = 0;
        int right = string.length() - 1;
        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String makePalindrome(String string) {
        if (string.isEmpty()) {
            return "";
        }

        int beginningOfSuffix = 0;

        while (!isPalindrome(string.substring(beginningOfSuffix))) {
            beginningOfSuffix++;
        }

        return string + new StringBuilder(string.substring(0, beginningOfSuffix)).reverse().toString();
    }
}