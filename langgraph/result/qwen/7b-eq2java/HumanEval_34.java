import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HumanEval_34 {
    public static List<Integer> unique(List<Integer> l) {
        Set<Integer> distinctElements = new HashSet<>(l);
        List<Integer> sortedElements = new ArrayList<>(distinctElements);
        sortedElements.sort(null);
        return sortedElements;
    }
}