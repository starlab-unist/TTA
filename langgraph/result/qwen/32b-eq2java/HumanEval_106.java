import java.util.ArrayList;
import java.util.List;

public class HumanEval_106 {
    public List<Integer> generate_alternating_sequence(int limit) {
        List<Integer> result = new ArrayList<>();
        int index = 1;
        while (index <= limit) {
            if (index % 2 == 0) {
                int factorial = 1;
                int inner_index = 1;
                while (inner_index <= index) {
                    factorial *= inner_index;
                    inner_index++;
                }
                result.add(factorial);
            } else {
                int summation = 0;
                int inner_index = 1;
                while (inner_index <= index) {
                    summation += inner_index;
                    inner_index++;
                }
                result.add(summation);
            }
            index++;
        }
        return result;
    }
}