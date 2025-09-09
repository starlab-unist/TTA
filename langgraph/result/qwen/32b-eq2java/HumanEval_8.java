import java.util.List;

public class HumanEval_8 {

    public static Tuple<Integer, Integer> calculateAggregates(List<Integer> values) {
        int totalSum = 0;
        int cumulativeProduct = 1;

        int index = 0;
        while (index < values.size()) {
            totalSum += values.get(index);
            cumulativeProduct *= values.get(index);
            index++;
        }

        return new Tuple<>(totalSum, cumulativeProduct);
    }
}

class Tuple<X, Y> {
    public final X first;
    public final Y second;

    public Tuple(X first, Y second) {
        this.first = first;
        this.second = second;
    }
}