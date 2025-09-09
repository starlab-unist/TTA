import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class HumanEval_34 {
    public List<Integer> extractDistinctElements(List<Integer> inputList) {
        Set<Integer> distinctElements = new TreeSet<>(inputList);
        List<Integer> sortedElements = new ArrayList<>(distinctElements);
        return sortedElements;
    }
}