public class HumanEval_84 {
    public static String solve(int N) {
        int sum = 0;
        String numStr = Integer.toString(N);
        for (char c : numStr.toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        return Integer.toBinaryString(sum).substring(2);
    }
}