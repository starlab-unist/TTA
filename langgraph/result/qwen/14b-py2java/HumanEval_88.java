import java.util.Arrays;
import java.util.List;

public class HumanEval_88 {
    public static List<Integer> sortArray(List<Integer> array) {
        if (array.isEmpty()) {
            return Arrays.asList();
        } else {
            boolean reverse = (array.get(0) + array.get(array.size() - 1)) % 2 == 0;
            return array.stream().sorted((a, b) -> reverse ? b.compareTo(a) : a.compareTo(b)).toList();
        }
    }
}