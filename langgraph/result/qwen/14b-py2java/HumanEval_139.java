public class HumanEval_139 {
    public static long specialFactorial(int n) {
        long fact_i = 1;
        long special_fact = 1;
        for (int i = 1; i <= n; i++) {
            fact_i *= i;
            special_fact *= fact_i;
        }
        return special_fact;
    }
}