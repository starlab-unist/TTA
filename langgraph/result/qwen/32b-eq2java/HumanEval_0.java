import java.util.List;

public class HumanEval_0 {
    public boolean containsNearbyElements(List<Double> values, double limit) {
        int index = 0;
        while (index < values.size()) {
            int innerIndex = 0;
            while (innerIndex < values.size()) {
                if (index != innerIndex) {
                    double gap = Math.abs(values.get(index) - values.get(innerIndex));
                    if (gap < limit) {
                        return true;
                    }
                }
                innerIndex++;
            }
            index++;
        }

        return false;
    }
}