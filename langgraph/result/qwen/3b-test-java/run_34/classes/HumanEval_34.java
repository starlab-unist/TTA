import java.util.*;

public class HumanEval_34 {
    public static List<Integer> extractDistinctElements(List<Integer> inputList) {
        Set<Integer> distinctElements = new HashSet<>(inputList);
        List<Integer> sortedElements = new ArrayList<>(distinctElements);
        Collections.sort(sortedElements);
        return sortedElements;
    }
}