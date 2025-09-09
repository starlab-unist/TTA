import java.util.ArrayList;
import java.util.List;

public class HumanEval_152 {
    public List<Integer> evaluateDifference(List<Integer> actual, List<Integer> guess) {
        List<Integer> differences = new ArrayList<>();
        int index = 0;
        while (index < actual.size()) {
            differences.add(Math.abs(actual.get(index) - guess.get(index)));
            index++;
        }
        return differences;
    }
}