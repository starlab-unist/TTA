import java.util.*;

public class HumanEval_58 {
    public static List<Integer> find_shared_elements(List<Integer> list_a, List<Integer> list_b) {
        Set<Integer> sharedItems = new HashSet<>();
        Iterator<Integer> iteratorA = list_a.iterator();
        
        while (iteratorA.hasNext()) {
            Integer elementA = iteratorA.next();
            for (Integer elementB : list_b) {
                if (elementA.equals(elementB)) {
                    sharedItems.add(elementA);
                }
            }
        }
        
        List<Integer> result = new ArrayList<>(sharedItems);
        Collections.sort(result);
        return result;
    }
}