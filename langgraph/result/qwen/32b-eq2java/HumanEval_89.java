public class HumanEval_89 {
    public String cipherText(String inputString) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        for (char character : inputString.toCharArray()) {
            if (alphabet.indexOf(character) != -1) {
                int newIndex = (alphabet.indexOf(character) + 4) % 26;
                result.append(alphabet.charAt(newIndex));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }
}