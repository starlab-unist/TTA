public class HumanEval_92 {
    public static boolean checkSumOfTwoEqualsThird(int a, int b, int c) {
        if (a + b == c || a + c == b || b + c == a) {
            return true;
        }
        return false;
    }
}