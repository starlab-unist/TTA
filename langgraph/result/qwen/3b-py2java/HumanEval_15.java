public class HumanEval_15 {
    public static String stringSequence(int n) {
        StringBuilder result = new StringBuilder();
        for (int x = 0; x <= n; x++) {
            result.append(x).append(" ");
        }
        return result.toString().trim();
    }
}