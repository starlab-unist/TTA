import java.util.List;
import java.util.Arrays;

public class HumanEval_20 {

    public static Tuple findClosestElements(List<Double> numbers) {
        Tuple closestPair = null;
        double distance = Double.MAX_VALUE;

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                if (i != j) {
                    double elem = numbers.get(i);
                    double elem2 = numbers.get(j);
                    double newDistance = Math.abs(elem - elem2);

                    if (distance > newDistance) {
                        distance = newDistance;
                        closestPair = new Tuple(Math.min(elem, elem2), Math.max(elem, elem2));
                    }
                }
            }
        }

        return closestPair;
    }

    // Simple Tuple class to hold two double values
    public static class Tuple {
        private final double first;
        private final double second;

        public Tuple(double first, double second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }

    public static void main(String[] args) {
        List<Double> numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        Tuple result = findClosestElements(numbers);
        System.out.println(result); // Example output
    }
}