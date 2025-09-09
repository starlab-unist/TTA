import java.util.List;
import java.util.ArrayList;

public class HumanEval_9 {
    public static List<Integer> computeRollingMaximum(List<Integer> values) {
        Integer currentMax = null;
        List<Integer> maxHistory = new ArrayList<>();

        int index = 0;
        while (index < values.size()) {
            if (currentMax == null) {
                currentMax = values.get(index);
            } else if (values.get(index) > currentMax) {
                currentMax = values.get(index);
            }

            maxHistory.add(currentMax);
            index++;
        }

        return maxHistory;
    }
}