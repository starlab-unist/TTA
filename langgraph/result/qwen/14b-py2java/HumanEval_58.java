import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;

public class HumanEval_58 {
    public static List<Integer> common(List<Integer> l1, List<Integer> l2) {
        Set<Integer> ret = new HashSet<>();
        for (Integer e1 : l1) {
            for (Integer e2 : l2) {
                if (e1.equals(e2)) {
                    ret.add(e1);
                }
            }
        }
        List<Integer> result = new ArrayList<>(ret);
        Collections.sort(result);
        return result;
    }
}