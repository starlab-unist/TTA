import java.util.List;
import java.util.Collections;

public class HumanEval_47 {
    public static double calculate_median(List<Double> numbers) {
        List<Double> sorted_numbers = new ArrayList<>(numbers);
        Collections.sort(sorted_numbers);
        int mid_index = sorted_numbers.size() / 2;
        
        if (sorted_numbers.size() % 2 == 1) {
            return sorted_numbers.get(mid_index);
        } else {
            return (sorted_numbers.get(mid_index - 1) + sorted_numbers.get(mid_index)) / 2.0;
        }
    }
}