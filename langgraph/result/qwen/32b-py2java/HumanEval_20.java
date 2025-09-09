import java.util.List;
import java.util.Arrays;

public class HumanEval_20 {

    public static Tuple<Double, Double> findClosestElements(List<Double> numbers) {
        Tuple<Double, Double> closestPair = null;
        Double distance = null;

        for (int idx = 0; idx < numbers.size(); idx++) {
            Double elem = numbers.get(idx);
            for (int idx2 = 0; idx2 < numbers.size(); idx2++) {
                Double elem2 = numbers.get(idx2);
                if (idx != idx2) {
                    Double newDistance = Math.abs(elem - elem2);
                    if (distance == null || newDistance < distance) {
                        distance = newDistance;
                        closestPair = new Tuple<>(Math.min(elem, elem2), Math.max(elem, elem2));
                    }
                }
            }
        }

        return closestPair;
    }

    public static class Tuple<X, Y> {
        public final X x;
        public final Y y;

        public Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}