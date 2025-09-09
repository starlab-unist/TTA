public class HumanEval_15 {
    public String stringSequence(int n) {
        StringBuilder result = new StringBuilder();
        for (int x = 0; x <= n; x++) {
            result.append(x);
            if (x < n) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}