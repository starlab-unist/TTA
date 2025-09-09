import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class HumanEval_136 {
    public static Pair<Integer, Integer> findExtremeValues(List<Integer> numbers) {
        List<Integer> negativeNumbers = new ArrayList<>();
        List<Integer> positiveNumbers = new ArrayList<>();

        for (Integer num : numbers) {
            if (num < 0) {
                negativeNumbers.add(num);
            } else if (num > 0) {
                positiveNumbers.add(num);
            }
        }

        Integer maxNegative = negativeNumbers.isEmpty() ? null : Collections.max(negativeNumbers);
        Integer minPositive = positiveNumbers.isEmpty() ? null : Collections.min(positiveNumbers);

        return new Pair<>(maxNegative, minPositive);
    }

    public static class Pair<T, U> {
        public final T first;
        public final U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }
}