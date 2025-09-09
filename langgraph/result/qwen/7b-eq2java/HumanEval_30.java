import java.util.ArrayList;
import java.util.List;

public class HumanEval_30 {
    public List<Integer> getPositive(List<Integer> l) {
        List<Integer> positiveNumbers = new ArrayList<>();
        int index = 0;

        while (index < l.size()) {
            if (l.get(index) > 0) {
                positiveNumbers.add(l.get(index));
            }
            index++;
        }

        return positiveNumbers;
    }
}