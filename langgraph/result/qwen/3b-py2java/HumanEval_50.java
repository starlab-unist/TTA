public class HumanEval_50 {

    public static String encodeShift(String s) {
        StringBuilder encoded = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                encoded.append((char) ((ch + 5 - base) % 26 + base));
            } else {
                encoded.append(ch);
            }
        }
        return encoded.toString();
    }

    public static String decodeShift(String s) {
        StringBuilder decoded = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                decoded.append((char) ((ch - 5 - base) % 26 + base));
            } else {
                decoded.append(ch);
            }
        }
        return decoded.toString();
    }
}