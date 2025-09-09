public class HumanEval_11 {

    public static String stringXOR(String a, String b) {
        StringBuilder result = new StringBuilder();
        int minLength = Math.min(a.length(), b.length());
        for (int i = 0; i < minLength; i++) {
            char x = a.charAt(i);
            char y = b.charAt(i);
            result.append(x == y ? '0' : '1');
        }
        return result.toString();
    }

}