import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_149 {

    public static List<String> sortedListSum(List<String> lst) {
        Collections.sort(lst);
        List<String> filteredSequence = new ArrayList<>();
        for (String element : lst) {
            if (element.length() % 2 == 0) {
                filteredSequence.add(element);
            }
        }
        Collections.sort(filteredSequence, (a, b) -> a.length() - b.length());
        return filteredSequence;
    }
}