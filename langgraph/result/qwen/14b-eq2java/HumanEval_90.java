import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_90 {
    public static Integer findSecondMinimum(List<Integer> numbers) {
        List<Integer> uniqueNumbers = numbers.stream()
                                             .distinct()
                                             .sorted()
                                             .collect(Collectors.toList());

        if (uniqueNumbers.size() < 2) {
            return null;
        }

        return uniqueNumbers.get(1);
    }
}