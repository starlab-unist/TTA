import java.util.List;

public class HumanEval_8 {
    public static Tuple<Integer, Integer> sumProduct(List<Integer> numbers) {
        int sumValue = 0;
        int prodValue = 1;

        for (int n : numbers) {
            sumValue += n;
            prodValue *= n;
        }
        return new Tuple<>(sumValue, prodValue);
    }

    public static class Tuple<X, Y> {
        private X first;
        private Y second;

        public Tuple(X first, Y second) {
            this.first = first;
            this.second = second;
        }

        public X getFirst() {
            return first;
        }

        public Y getSecond() {
            return second;
        }
    }
}