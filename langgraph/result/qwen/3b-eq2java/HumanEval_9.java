import java.util.List;

public class HumanEval_9 {

    public static List<Integer> computeRollingMaximum(List<Integer> values) {
        Integer currentMax = null;
        List<Integer> maxHistory = new java.util.ArrayList<>();

        int index = 0;
        while (index < values.size()) {
            if (currentMax == null || values.get(index) > currentMax) {
                currentMax = values.get(index);
            }
            maxHistory.add(currentMax);
            index++;
        }

        return maxHistory;
    }
}