import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_70 {
    public List<Integer> alternateSortSequence(List<Integer> sequence) {
        List<Integer> result = new ArrayList<>();
        boolean toggle = true;
        while (!sequence.isEmpty()) {
            int selectedValue = toggle ? Collections.min(sequence) : Collections.max(sequence);
            result.add(selectedValue);
            sequence.remove(Integer.valueOf(selectedValue));
            toggle = !toggle;
        }
        return result;
    }
}