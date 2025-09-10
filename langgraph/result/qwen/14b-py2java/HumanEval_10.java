public class HumanEval_10 {
    public static boolean isPalindrome(String string) {
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

        StringBuilder suffix = new StringBuilder(string.substring(0, beginningOfSuffix));
        return string + suffix.reverse().toString();
    }
}