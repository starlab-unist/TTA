import java.util.List;
import java.util.ArrayList;

public class HumanEval_9 {

    public static List<Integer> rollingMax(List<Integer> numbers) {
        Integer runningMax = null;
        List<Integer> result = new ArrayList<>();

        for (Integer n : numbers) {
            if (runningMax == null) {
                runningMax = n;
            } else {
                runningMax = Math.max(runningMax, n);
            }

            result.add(runningMax);
        }

        return result;
    }
}