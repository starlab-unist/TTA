import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_88 {
    public static List<Integer> arrangeSequence(List<Integer> sequence) {
        if (sequence.isEmpty()) {
            return new ArrayList<>();
        }
        
        boolean reverseOrder = (sequence.get(0) + sequence.get(sequence.size() - 1)) % 2 == 0;
        List<Integer> sortedSequence = new ArrayList<>(sequence);
        Collections.sort(sortedSequence);
        
        if (reverseOrder) {
            Collections.reverse(sortedSequence);
        }
        
        return sortedSequence;
    }
}