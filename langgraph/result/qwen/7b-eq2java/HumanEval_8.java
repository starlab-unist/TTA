import java.util.List;

public class HumanEval_8 {
    public static Tuple<Integer, Integer> calculateAggregates(List<Integer> numbers) {
        int sumValue = 0;
        int prodValue = 1;

        int index = 0;
        while (index < numbers.size()) {
            sumValue += numbers.get(index);
            prodValue *= numbers.get(index);
            index++;
        }

        return new Tuple<>(sumValue, prodValue);
    }
}