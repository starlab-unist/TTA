public class HumanEval_8 {

    public static Tuple calculateAggregates(List<Integer> values) {
        int totalSum = 0;
        int cumulativeProduct = 1;

        int index = 0;
        while (index < values.size()) {
            totalSum += values.get(index);
            cumulativeProduct *= values.get(index);
            index++;
        }

        return new Tuple(totalSum, cumulativeProduct);
    }

    // Inner class to represent a tuple
    public static class Tuple {
        private final int sum;
        private final int product;

        public Tuple(int sum, int product) {
            this.sum = sum;
            this.product = product;
        }

        public int getSum() {
            return sum;
        }

        public int getProduct() {
            return product;
        }
    }
}