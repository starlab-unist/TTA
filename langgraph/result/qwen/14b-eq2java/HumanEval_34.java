import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class HumanEval_34 {
    public static List<Integer> extract_distinct_elements(List<Integer> input_list) {
        Set<Integer> distinct_elements = new TreeSet<>(input_list);
        List<Integer> sorted_elements = new ArrayList<>(distinct_elements);
        return sorted_elements;
    }
}