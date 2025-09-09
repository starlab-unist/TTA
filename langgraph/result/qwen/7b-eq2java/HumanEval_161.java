public class HumanEval_161 {
    public static String transformString(String inputString) {
        boolean modified = false;
        int position = 0;
        char[] resultChars = inputString.toCharArray();
        for (char ch : inputString.toCharArray()) {
            if (Character.isLetter(ch)) {
                resultChars[position] = Character.isUpperCase(ch) ? Character.toLowerCase(ch) : Character.toUpperCase(ch);
                modified = true;
            }
            position++;
        }
        String transformedString = new String(resultChars);
        if (!modified) {
            return new StringBuilder(transformedString).reverse().toString();
        }
        return transformedString;
    }
}