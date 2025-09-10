public class HumanEval_27 {
    public static String invertCharacterCase(String inputText) {
        StringBuilder result = new StringBuilder();
        for (char c : inputText.toCharArray()) {
            if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));
            } else if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}