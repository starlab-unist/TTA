public class HumanEval_50 {
    public static String encodeShift(String s) {
        StringBuilder encoded = new StringBuilder();
        for (char ch : s.toCharArray()) {
            encoded.append((char) (((ch - 'a' + 5) % 26) + 'a'));
        }
        return encoded.toString();
    }

    public static String decodeShift(String s) {
        StringBuilder decoded = new StringBuilder();
        for (char ch : s.toCharArray()) {
            decoded.append((char) (((ch - 'a' - 5 + 26) % 26) + 'a'));
        }
        return decoded.toString();
    }
}