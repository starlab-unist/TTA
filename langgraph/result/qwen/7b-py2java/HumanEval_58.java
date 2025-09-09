import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HumanEval_58 {
    public List<Integer> common(List<Integer> l1, List<Integer> l2) {
        Set<Integer> ret = new HashSet<>();
        for (Integer e1 : l1) {
            for (Integer e2 : l2) {
                if (e1.equals(e2)) {
                    ret.add(e1);
                }
            }
        }
        return List.copyOf(ret.stream().sorted().toList());
    }
}