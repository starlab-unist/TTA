import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_57 {
    public static boolean checkMonotonicSequence(List<Integer> sequence) {
        List<Integer> ascending = new ArrayList<>(sequence);
        List<Integer> descending = new ArrayList<>(sequence);
        
        Collections.sort(ascending);
        Collections.sort(descending, Collections.reverseOrder());
        
        if (sequence.equals(ascending) || sequence.equals(descending)) {
            return true;
        }
        return false;
    }
}