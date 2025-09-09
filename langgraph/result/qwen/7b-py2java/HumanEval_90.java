import java.util.*;

public class HumanEval_90 {
    public static Integer nextSmallest(List<Integer> lst) {
        Set<Integer> set = new HashSet<>(lst);
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        return sortedList.size() < 2 ? null : sortedList.get(1);
    }
}