import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HumanEval_90 {
    public Integer findSecondMinimum(List<Integer> numbers) {
        Set<Integer> uniqueSet = new HashSet<>(numbers);
        List<Integer> uniqueNumbers = new ArrayList<>(uniqueSet);
        Collections.sort(uniqueNumbers);

        if (uniqueNumbers.size() < 2) {
            return null;
        }

        return uniqueNumbers.get(1);
    }
}