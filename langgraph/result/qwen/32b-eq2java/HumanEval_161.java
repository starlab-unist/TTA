public class HumanEval_161 {
    public String transformString(String inputString) {
        boolean modified = false;
        int position = 0;
        char[] resultChars = inputString.toCharArray();
        for (char c : inputString.toCharArray()) {
            if (Character.isLetter(c)) {
                resultChars[position] = Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
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