public class HumanEval_139 {
    public static long computeSpecialProduct(int n) {
        long currentFactorial = 1;
        long cumulativeProduct = 1;
        int index = 1;

        while (index <= n) {
            currentFactorial *= index;
            cumulativeProduct *= currentFactorial;
            index++;
        }

        return cumulativeProduct;
    }
}