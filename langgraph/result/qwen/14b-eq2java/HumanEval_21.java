import java.util.List;
import java.util.ArrayList;

public class HumanEval_21 {

    public static List<Double> normalizeValues(List<Double> values) {
        double smallestValue = Collections.min(values);
        double largestValue = Collections.max(values);
        double rangeValue = largestValue - smallestValue;

        List<Double> normalizedList = new ArrayList<>();
        for (double value : values) {
            double normalizedValue = (value - smallestValue) / rangeValue;
            normalizedList.add(normalizedValue);
        }

        return normalizedList;
    }
}