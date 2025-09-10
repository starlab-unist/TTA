import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class HumanEval_90 {
    public static Integer nextSmallest(List<Integer> lst) {
        Set<Integer> uniqueElements = new TreeSet<>(lst);
        if (uniqueElements.size() < 2) {
            return null;
        } else {
            return uniqueElements.stream().skip(1).findFirst().get();
        }
    }
}