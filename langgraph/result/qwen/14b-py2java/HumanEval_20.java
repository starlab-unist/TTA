import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class HumanEval_20 {

    public static List<Double> findClosestElements(List<Double> numbers) {
        List<Double> closestPair = null;
        Double distance = null;

        for (int idx = 0; idx < numbers.size(); idx++) {
            double elem = numbers.get(idx);
            for (int idx2 = 0; idx2 < numbers.size(); idx2++) {
                double elem2 = numbers.get(idx2);
                if (idx != idx2) {
                    if (distance == null) {
                        distance = Math.abs(elem - elem2);
                        closestPair = new ArrayList<>();
                        closestPair.add(Math.min(elem, elem2));
                        closestPair.add(Math.max(elem, elem2));
                    } else {
                        double newDistance = Math.abs(elem - elem2);
                        if (newDistance < distance) {
                            distance = newDistance;
                            closestPair = new ArrayList<>();
                            closestPair.add(Math.min(elem, elem2));
                            closestPair.add(Math.max(elem, elem2));
                        }
                    }
                }
            }
        }

        return closestPair;
    }
}