public class HumanEval_50 {

    public String shift_encode(String inputString) {
        StringBuilder encodedChars = new StringBuilder();
        for (char character : inputString.toCharArray()) {
            char shiftedChar = (char) (((character + 5 - 'a') % 26) + 'a');
            encodedChars.append(shiftedChar);
        }
        return encodedChars.toString();
    }

    public String shift_decode(String encodedString) {
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