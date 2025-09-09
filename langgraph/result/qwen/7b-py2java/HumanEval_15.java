public class HumanEval_15 {
    public static String stringSequence(int n) {
        StringBuilder result = new StringBuilder();
        for (int x = 0; x <= n; x++) {
            if (x > 0) {
                result.append(" ");
            }
            result.append(x);
        }
        return result.toString();
    }
}