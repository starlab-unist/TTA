class HumanEval_50 {
    public static String encodeShift(String s) {
        StringBuilder encoded = new StringBuilder();
        for (char ch : s.toCharArray()) {
            char shifted = (char) (((ch + 5 - 'a') % 26) + 'a');
            encoded.append(shifted);
        }
        return encoded.toString();
    }

    public static String decodeShift(String s) {
        StringBuilder decoded = new StringBuilder();
        for (char ch : s.toCharArray()) {
            char shifted = (char) (((ch - 5 - 'a') % 26 + 26) % 26 + 'a'); // Ensure non-negative result
            decoded.append(shifted);
        }
        return decoded.toString();
    }
}