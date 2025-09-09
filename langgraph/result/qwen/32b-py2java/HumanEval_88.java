import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HumanEval_88 {
    public static List<Integer> sortArray(List<Integer> array) {
        if (array.isEmpty()) {
            return Collections.emptyList();
        }
        boolean reverse = (array.get(0) + array.get(array.size() - 1)) % 2 == 0;
        if (reverse) {
            array.sort(Collections.reverseOrder());
        } else {
            Collections.sort(array);
        }
        return array;
    }
}