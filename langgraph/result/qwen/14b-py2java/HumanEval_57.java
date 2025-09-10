import java.util.List;
import java.util.Collections;

public class HumanEval_57 {
    public static boolean monotonic(List<Integer> l) {
        List<Integer> sortedList = new ArrayList<>(l);
        Collections.sort(sortedList);
        if (l.equals(sortedList) || l.equals(Collections.reverse(sortedList))) {
            return true;
        }
        return false;
    }
}