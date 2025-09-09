import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_120 {
    public List<Integer> findTopKElements(List<Integer> sequence, int count) {
        if (count == 0) {
            return new ArrayList<>();
        }

        List<Integer> sortedSequence = new ArrayList<>(sequence);
        Collections.sort(sortedSequence);
        List<Integer> topElements = sortedSequence.subList(sortedSequence.size() - count, sortedSequence.size());

        return topElements;
    }
}