import java.util.HashMap;
import java.util.Map;

public class HumanEval_93 {
    public static String encode(String message) {
        String vowels = "aeiouAEIOU";
        Map<Character, Character> vowelsReplace = new HashMap<>();
        for (char i : vowels.toCharArray()) {
            vowelsReplace.put(i, (char)(i + 2));
        }
        StringBuilder encodedMessage = new StringBuilder();
        for (char i : message.toCharArray()) {
            if (vowels.indexOf(i) != -1) {
                encodedMessage.append(vowelsReplace.get(i));
            } else {
                encodedMessage.append(i);
            }
        }
        return encodedMessage.toString().toUpperCase();
    }
}