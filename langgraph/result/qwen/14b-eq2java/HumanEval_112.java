public class HumanEval_112 {
    public static String[] filterAndCheckPalindrome(String inputString, String charsToRemove) {
        StringBuilder filteredString = new StringBuilder();
        for (char character : inputString.toCharArray()) {
            if (charsToRemove.indexOf(character) == -1) {
                filteredString.append(character);
            }
        }
        
        String s = filteredString.toString();
        boolean isPalindrome = s.equals(new StringBuilder(s).reverse().toString());
        
        return new String[]{s, Boolean.toString(isPalindrome)};
    }
}