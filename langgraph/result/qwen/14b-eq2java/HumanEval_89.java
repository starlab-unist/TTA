public class HumanEval_89 {
    public static String cipher_text(String input_string) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        for (char character : input_string.toCharArray()) {
            int index = alphabet.indexOf(character);
            if (index != -1) {
                int newIndex = (index + 4) % 26;
                result.append(alphabet.charAt(newIndex));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }
}