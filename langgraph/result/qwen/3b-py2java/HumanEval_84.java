public class HumanEval_84 {

    public static String solve(int N) {
        int sum = 0;
        for (char c : Integer.toString(N).toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        return Integer.toBinaryString(sum).substring(2);
    }

}