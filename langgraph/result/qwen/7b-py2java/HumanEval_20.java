import java.util.List;
import java.util.ArrayList;

public class HumanEval_20 {

    public static Pair<Double, Double> findClosestElements(List<Double> numbers) {
        Pair<Double, Double> closestPair = null;
        double distance = Double.MAX_VALUE;

        for (int idx = 0; idx < numbers.size(); idx++) {
            for (int idx2 = 0; idx2 < numbers.size(); idx2++) {
                if (idx != idx2) {
                    double newDistance = Math.abs(numbers.get(idx) - numbers.get(idx2));
                    if (newDistance < distance) {
                        distance = newDistance;
                        closestPair = new Pair<>(Math.min(numbers.get(idx), numbers.get(idx2)), Math.max(numbers.get(idx), numbers.get(idx2)));
                    }
                }
            }
        }

        return closestPair;
    }
}