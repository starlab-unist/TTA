import java.util.List;

public class HumanEval_0 {
    public static boolean containsNearbyElements(List<Double> values, double limit) {
        int idx = 0;
        while (idx < values.size()) {
            int idx2 = 0;
            while (idx2 < values.size()) {
                if (idx != idx2) {
                    double distance = Math.abs(values.get(idx) - values.get(idx2));
                    if (distance < limit) {
                        return true;
                    }
                }
                idx2++;
            }
            idx++;
        }

        return false;
    }
}