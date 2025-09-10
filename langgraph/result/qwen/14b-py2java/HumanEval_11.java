public class HumanEval_11 {
    public static String stringXor(String a, String b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            char x = a.charAt(i);
            char y = b.charAt(i);
            if (x == y) {
                result.append('0');
            } else {
                result.append('1');
            }
        }
        return result.toString();
    }
}