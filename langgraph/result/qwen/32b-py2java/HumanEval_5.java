import java.util.ArrayList;
import java.util.List;

public class HumanEval_5 {

    public static List<Integer> intersperse(List<Integer> numbers, int delimiter) {
        if (numbers.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numbers.size() - 1; i++) {
            result.add(numbers.get(i));
            result.add(delimiter);
        }

        result.add(numbers.get(numbers.size() - 1));

        return result;
    }
}