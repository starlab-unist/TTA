public class HumanEval_112 {
    public static Pair<String, Boolean> reverseDelete(String inputString, String charsToRemove) {
        StringBuilder filteredStringBuilder = new StringBuilder();
        for (char character : inputString.toCharArray()) {
            if (!charsToRemove.contains(String.valueOf(character))) {
                filteredStringBuilder.append(character);
            }
        }
        String filteredString = filteredStringBuilder.toString();
        boolean isPalindrome = filteredString.equals(new StringBuilder(filteredString).reverse().toString());
        return new Pair<>(filteredString, isPalindrome);
    }
}