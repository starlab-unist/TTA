import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_90 {
    public static Integer nextSmallest(List<Integer> lst) {
        List<Integer> uniqueNumbers = new ArrayList<>(new HashSet<>(lst));
        Collections.sort(uniqueNumbers);

        if (uniqueNumbers.size() < 2) {
            return null;
        }

        return uniqueNumbers.get(1);
    }
}