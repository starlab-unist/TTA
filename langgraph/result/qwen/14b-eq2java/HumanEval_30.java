import java.util.ArrayList;
import java.util.List;

public class HumanEval_30 {
    public static List<Integer> extract_positive_numbers(List<Integer> input_list) {
        List<Integer> positive_numbers = new ArrayList<>();
        int index = 0;

        while (index < input_list.size()) {
            if (input_list.get(index) > 0) {
                positive_numbers.add(input_list.get(index));
            }
            index++;
        }

        return positive_numbers;
    }
}