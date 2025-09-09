import java.util.List;
import java.util.Arrays;

public class HumanEval_20 {

    public static double[] determineNearestPair(List<Double> values) {
        double[] nearestPair = null;
        double minGap = Double.MAX_VALUE;

        int index = 0;
        while (index < values.size()) {
            int innerIndex = 0;
            while (innerIndex < values.size()) {
                if (index != innerIndex) {
                    double currentDifference = Math.abs(values.get(index) - values.get(innerIndex));
                    if (currentDifference < minGap) {
                        minGap = currentDifference;
                        nearestPair = Arrays.stream(new Double[]{values.get(index), values.get(innerIndex)})
                                            .sorted()
                                            .mapToDouble(Double::doubleValue)
                                            .toArray();
                    }
                }
                innerIndex++;
            }
            index++;
        }

        return nearestPair;
    }
}