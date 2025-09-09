import java.util.List;
import java.util.Arrays;

public class HumanEval_20 {

    public static Tuple<Float, Float> determineNearestPair(List<Float> values) {
        Tuple<Float, Float> nearestPair = null;
        Float minGap = null;

        int index = 0;
        while (index < values.size()) {
            int innerIndex = 0;
            while (innerIndex < values.size()) {
                if (index != innerIndex) {
                    float currentDifference = Math.abs(values.get(index) - values.get(innerIndex));
                    if (minGap == null || currentDifference < minGap) {
                        minGap = currentDifference;
                        nearestPair = new Tuple<>(Math.min(values.get(index), values.get(innerIndex)), Math.max(values.get(index), values.get(innerIndex)));
                    }
                }
                innerIndex++;
            }
            index++;
        }

        return nearestPair;
    }

    public static class Tuple<X, Y> {
        public final X x;
        public final Y y;

        public Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}