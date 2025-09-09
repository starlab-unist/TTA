import java.util.List;
import java.util.Arrays;

public class HumanEval_20 {

    public static Tuple<Double, Double> determineNearestPair(List<Double> values) {
        Tuple<Double, Double> nearestPair = null;
        Double minGap = null;

        int index = 0;
        while (index < values.size()) {
            int innerIndex = 0;
            while (innerIndex < values.size()) {
                if (index != innerIndex) {
                    double currentDifference = Math.abs(values.get(index) - values.get(innerIndex));
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

    public static void main(String[] args) {
        List<Double> numbers = Arrays.asList(1.5, 3.2, 4.8, 2.1, 5.9);
        Tuple<Double, Double> result = determineNearestPair(numbers);
        System.out.println("Nearest pair: (" + result.x + ", " + result.y + ")");
    }
}

class Tuple<X, Y> {
    public final X x;
    public final Y y;

    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }
}