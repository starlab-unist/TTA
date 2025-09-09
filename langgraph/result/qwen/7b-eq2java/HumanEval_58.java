import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HumanEval_58 {
    public static List<Integer> common(List<Integer> l1, List<Integer> l2) {
        Set<Integer> ret = new HashSet<>();
        Iterator<Integer> iteratorA = l1.iterator();
        
        while (iteratorA.hasNext()) {
            Integer elementA = iteratorA.next();
            for (Integer elementB : l2) {
                if (elementA.equals(elementB)) {
                    ret.add(elementA);
                }
            }
        }
        
        return List.copyOf(ret.stream().sorted().toList());
    }
}