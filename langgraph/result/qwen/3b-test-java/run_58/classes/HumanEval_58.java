import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HumanEval_58 {

    public static List<Integer> findSharedElements(List<Integer> listA, List<Integer> listB) {
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

        return new ArrayList<>(sharedItems);
    }
}