import java.util.HashMap;
import java.util.Map;

public class HumanEval_93 {
    public static String encode(String message) {
        String vowels = "aeiouAEIOU";
        Map<Character, Character> vowelsReplace = new HashMap<>();
        for (char i : vowels.toCharArray()) {
            vowelsReplace.put(i, (char) (i + 2));
        }
        StringBuilder encodedMessage = new StringBuilder();
        for (char i : message.toCharArray()) {
            char swappedChar = Character.isUpperCase(i) ? Character.toLowerCase(i) : Character.toUpperCase(i);
            encodedMessage.append(vowelsReplace.getOrDefault(swappedChar, swappedChar));
        }
        return encodedMessage.toString();
    }
}