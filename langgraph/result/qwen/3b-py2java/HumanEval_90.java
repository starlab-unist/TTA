import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class HumanEval_90 {

    public static Integer nextSmallest(List<Integer> lst) {
        List<Integer> sortedSet = new ArrayList<>(new HashSet<>(lst));
        Collections.sort(sortedSet);
        return sortedSet.size() < 2 ? null : sortedSet.get(1);
    }
}