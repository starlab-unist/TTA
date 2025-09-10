public class HumanEval_161 {

    public static String transformString(String inputString) {
        boolean modified = false;
        int position = 0;
        char[] resultChars = inputString.toCharArray();
        for (char charAt : inputString.toCharArray()) {
            if (Character.isLetter(charAt)) {
                resultChars[position] = Character.isUpperCase(charAt) ? Character.toLowerCase(charAt) : Character.toUpperCase(charAt);
                modified = true;
            }
            position++;
        }
        String transformedString = new String(resultChars);
        if (!modified) {
            return transformedString.reverse().toString();
        }
        return transformedString;
    }

    // method name: solve -> transformString
    // parameter name: s -> inputString
    // variable name: flg -> modified, idx -> position, new_str -> resultChars
}