import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class HumanEval_90 {
    public static Integer nextSmallest(List<Integer> lst) {
        List<Integer> uniqueList = new ArrayList<>(new HashSet<>(lst));
        Collections.sort(uniqueList);
        return uniqueList.size() < 2 ? null : uniqueList.get(1);
    }
}