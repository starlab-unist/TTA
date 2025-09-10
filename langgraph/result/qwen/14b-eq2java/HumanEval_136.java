import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class HumanEval_136 {
    public static List<Optional<Integer>> findExtremeValues(List<Integer> numbers) {
        List<Integer> negativeNumbers = new ArrayList<>();
        List<Integer> positiveNumbers = new ArrayList<>();

        for (Integer num : numbers) {
            if (num < 0) {
                negativeNumbers.add(num);
            } else if (num > 0) {
                positiveNumbers.add(num);
            }
        }

        Optional<Integer> maxNegative = negativeNumbers.isEmpty() ? Optional.empty() : Optional.of(negativeNumbers.stream().max(Integer::compare).get());
        Optional<Integer> minPositive = positiveNumbers.isEmpty() ? Optional.empty() : Optional.of(positiveNumbers.stream().min(Integer::compare).get());

        List<Optional<Integer>> result = new ArrayList<>();
        result.add(maxNegative);
        result.add(minPositive);

        return result;
    }
}