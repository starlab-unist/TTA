public class HumanEval_112 {

    public static String[] filterAndCheckPalindrome(String inputString, String charsToRemove) {
        StringBuilder filteredStringBuilder = new StringBuilder();
        for (char c : inputString.toCharArray()) {
            if (!charsToRemove.contains(String.valueOf(c))) {
                filteredStringBuilder.append(c);
            }
        }
        String filteredString = filteredStringBuilder.toString();
        boolean isPalindrome = filteredString.equals(filteredString.reverse().toString());
        return new String[]{filteredString, Boolean.toString(isPalindrome)};
    }
}