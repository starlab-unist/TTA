import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Collections;

class HumanEval_58 {
    public List<Integer> findSharedElements(List<Integer> listA, List<Integer> listB) {
        Set<Integer> sharedItems = new HashSet<>();
        Iterator<Integer> iteratorA = listA.iterator();
        
        while (iteratorA.hasNext()) {
            Integer elementA = iteratorA.next();
            for (Integer elementB : listB) {
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