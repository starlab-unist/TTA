public class HumanEval_93 {
    public static String encode(String message) {
        String vowels = "aeiouAEIOU";
        StringBuilder encodedMessage = new StringBuilder();
        
        for (char c : message.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                char replacedChar = (char) (c + 2);
                encodedMessage.append(replacedChar);
            } else {
                encodedMessage.append(c);
            }
        }
        
        return encodedMessage.toString().swapCase();
    }
}