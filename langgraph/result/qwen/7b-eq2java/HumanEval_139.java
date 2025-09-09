public class HumanEval_139 {
    public static long specialFactorial(int n) {
        long currentFactorial = 1;
        long cumulativeProduct = 1;
        int index = 1;

        while (index <= n) {
            currentFactorial *= index;
            cumulativeProduct *= currentFactorial;
            index += 1;
        }

        return cumulativeProduct;
    }
}