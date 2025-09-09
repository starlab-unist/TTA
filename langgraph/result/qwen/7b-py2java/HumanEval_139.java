public class HumanEval_139 {
    public static long specialFactorial(int n) {
        long factI = 1;
        long specialFact = 1;
        for (int i = 1; i <= n; i++) {
            factI *= i;
            specialFact *= factI;
        }
        return specialFact;
    }
}