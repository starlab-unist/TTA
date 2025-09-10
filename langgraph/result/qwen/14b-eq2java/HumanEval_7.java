import java.util.ArrayList;
import java.util.List;

public class HumanEval_7 {
    public static List<String> extractMatchingStrings(List<String> sequence, String pattern) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < sequence.size()) {
            if (sequence.get(index).contains(pattern)) {
                result.add(sequence.get(index));
            }
            index += 1;
        }
        return result;
    }
}