import java.util.List;

public class human_eval_0 {

    public static boolean containsNearbyElements(List<Double> values, double limit) {
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

/*
Changes made:
- method name: hasCloseElements -> containsNearbyElements
- parameter names: numbers -> values, threshold -> limit
- outer and inner loops: for-loops -> while-loops
- variable names: i -> index, j -> innerIndex, distance -> gap
- removed intermediate variables elem/elem2, directly used values.get(index)/values.get(innerIndex)
*/
