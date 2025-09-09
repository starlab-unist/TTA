public class HumanEval_93 {
    public static String encode(String message) {
        String vowels = "aeiouAEIOU";
        java.util.Map<Character, Character> vowelsReplace = new java.util.HashMap<>();
        
        for (char i : vowels.toCharArray()) {
            vowelsReplace.put(i, (char) (ord(i) + 2));
        }
        
        message = message.toUpperCase();
        
        StringBuilder encodedMessage = new StringBuilder();
        
        for (char i : message.toCharArray()) {
            if (vowelsReplace.containsKey(i)) {
                encodedMessage.append(vowelsReplace.get(i));
            } else {
                encodedMessage.append(i);
            }
        }
        
        return encodedMessage.toString();
    }
}