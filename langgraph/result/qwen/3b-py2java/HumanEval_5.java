import java.util.List;

public class HumanEval_5 {

    public static List<Integer> intersperse(List<Integer> numbers, int delimiter) {
        if (numbers == null || numbers.isEmpty()) {
            return List.of();
        }

        List<Integer> result = new java.util.ArrayList<>();

        for (int i = 0; i < numbers.size() - 1; i++) {
            result.add(numbers.get(i));
            result.add(delimiter);
        }

        result.add(numbers.get(numbers.size() - 1));

        return result;
    }
}