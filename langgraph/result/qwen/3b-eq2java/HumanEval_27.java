public class HumanEval_27 {

    public static String invertCharacterCase(String inputText) {
        StringBuilder result = new StringBuilder();
        for (char charAt : inputText.toCharArray()) {
            if (Character.isLowerCase(charAt)) {
                result.append(Character.toUpperCase(charAt));
            } else if (Character.isUpperCase(charAt)) {
                result.append(Character.toLowerCase(charAt));
            } else {
                result.append(charAt);
            }
        }
        return result.toString();
    }

}