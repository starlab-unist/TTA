public class HumanEval_50 {
    public static String shiftEncode(String inputString) {
        StringBuilder encodedChars = new StringBuilder();
        for (char character : inputString.toCharArray()) {
            char shiftedChar = (char) (((character + 5 - 'a') % 26) + 'a');
            encodedChars.append(shiftedChar);
        }
        return encodedChars.toString();
    }

    public static String shiftDecode(String encodedString) {
        StringBuilder decodedChars = new StringBuilder();
        int index = 0;
        while (index < encodedString.length()) {
            char originalChar = (char) (((encodedString.charAt(index) - 5 - 'a') % 26) + 'a');
            decodedChars.append(originalChar);
            index++;
        }
        return decodedChars.toString();
    }
}