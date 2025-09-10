import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_120 {
    public static List<Integer> maximum(List<Integer> arr, int k) {
        if (k == 0) {
            return Arrays.asList();
        }
        arr.sort(Integer::compareTo);
        return arr.subList(arr.size() - k, arr.size());
    }
}