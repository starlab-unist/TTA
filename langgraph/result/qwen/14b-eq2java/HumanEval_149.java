import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_149 {
    public static List<String> evenLengthSortedElements(List<String> sequence) {
        Collections.sort(sequence);
        List<String> filteredSequence = new ArrayList<>();
        for (String element : sequence) {
            if (element.length() % 2 == 0) {
                filteredSequence.add(element);
            }
        }
        Collections.sort(filteredSequence, (a, b) -> Integer.compare(a.length(), b.length()));
        return filteredSequence;
    }
}