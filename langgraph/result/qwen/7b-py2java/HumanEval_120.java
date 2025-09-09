import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_120 {
    public static List<Integer> maximum(int[] arr, int k) {
        if (k == 0) {
            return Arrays.asList();
        }
        Arrays.sort(arr);
        List<Integer> ans = Arrays.stream(arr).skip(Math.max(0, arr.length - k)).boxed().collect(Collectors.toList());
        return ans;
    }
}