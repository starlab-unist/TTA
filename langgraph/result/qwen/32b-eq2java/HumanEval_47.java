import java.util.List;
import java.util.Collections;

public class HumanEval_47 {
    public double calculateMedian(List<Double> numbers) {
        List<Double> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        int midIndex = sortedNumbers.size() / 2;
        
        if (sortedNumbers.size() % 2 == 1) {
            return sortedNumbers.get(midIndex);
        } else {
            return (sortedNumbers.get(midIndex - 1) + sortedNumbers.get(midIndex)) / 2.0;
        }
    }
}