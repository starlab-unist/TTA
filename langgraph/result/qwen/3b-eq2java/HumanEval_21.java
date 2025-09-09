import java.util.List;

public class HumanEval_21 {

    public static List<Double> normalizeValues(List<Double> values) {
        double smallestValue = Double.MAX_VALUE;
        double largestValue = Double.MIN_VALUE;

        // Find the smallest and largest values in the list
        for (double value : values) {
            if (value < smallestValue) {
                smallestValue = value;
            }
            if (value > largestValue) {
                largestValue = value;
            }
        }

        double rangeValue = largestValue - smallestValue;

        List<Double> normalizedList = new ArrayList<>();
        for (double value : values) {
            double normalizedValue = (value - smallestValue) / rangeValue;
            normalizedList.add(normalizedValue);
        }

        return normalizedList;
    }
}