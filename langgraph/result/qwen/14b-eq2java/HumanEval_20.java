import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class HumanEval_20 {

    public static List<Double> determineNearestPair(List<Double> values) {
        List<Double> nearestPair = null;
        Double minGap = null;

        int index = 0;
        while (index < values.size()) {
            int innerIndex = 0;
            while (innerIndex < values.size()) {
                if (index != innerIndex) {
                    Double currentDifference = Math.abs(values.get(index) - values.get(innerIndex));
                    if (minGap == null || currentDifference < minGap) {
                        minGap = currentDifference;
                        nearestPair = new ArrayList<>(List.of(values.get(index), values.get(innerIndex)));
                        Collections.sort(nearestPair);
                    }
                }
                innerIndex += 1;
            }
            index += 1;
        }

        return nearestPair;
    }
}