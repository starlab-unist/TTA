import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HumanEval_20 {

    // Source Code
    static class HumanEval_20 {
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

    // Transformed Code
    static class TransformedHumanEval {
        public static HumanEval_20.Tuple<Float, Float> determineNearestPair(List<Float> values) {
            HumanEval_20.Tuple<Float, Float> nearestPair = null;
            Float minGap = null;

            int index = 0;
            while (index < values.size()) {
                int innerIndex = 0;
                while (innerIndex < values.size()) {
                    if (index != innerIndex) {
                        float currentDifference = Math.abs(values.get(index) - values.get(innerIndex));
                        if (minGap == null || currentDifference < minGap) {
                            minGap = currentDifference;
                            nearestPair = new HumanEval_20.Tuple<>(Math.min(values.get(index), values.get(innerIndex)), Math.max(values.get(index), values.get(innerIndex)));
                        }
                    }
                    innerIndex++;
                }
                index++;
            }

            return nearestPair;
        }
    }

    // Test Cases
    private static final List<List<Double>> testCases = Arrays.asList(
        Arrays.asList(1.0, 2.0, 3.0, 4.0),
        Arrays.asList(5.5, 3.3, 2.2, 8.8, 9.9),
        Arrays.asList(-1.0, -2.0, -3.0, -4.0),
        Arrays.asList(10.0, 10.0, 10.0, 10.0),
        Arrays.asList(0.1, 0.2, 0.3, 0.4, 0.5),
        Arrays.asList(100.0, 99.0, 101.0, 98.0),
        Arrays.asList(0.0, 0.0, 0.0, 0.0),
        Arrays.asList(1.5, 2.5, 3.5, 4.5),
        Arrays.asList(1000.1, 1000.2, 999.9, 1001.1),
        Arrays.asList(1.0)
    );

    private static Stream<Arguments> provideTestCases() {
        return testCases.stream().map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void findClosestElements_vs_determineNearestPair(List<Double> inputNumbers) {
        HumanEval_20.Tuple<Double, Double> sourceResult = HumanEval_20.findClosestElements(inputNumbers);

        // Use the correct Tuple class reference here
        HumanEval_20.Tuple<Float, Float> transformedResult = TransformedHumanEval.determineNearestPair(
            inputNumbers.stream().map(Double::floatValue).collect(Collectors.toList())
        );

        if (inputNumbers.size() == 1) {
            assertNull(sourceResult);
            assertNull(transformedResult);
        } else {
            assertEquals(sourceResult.x.floatValue(), transformedResult.x, "x values should be equal");
            assertEquals(sourceResult.y.floatValue(), transformedResult.y, "y values should be equal");
        }
    }
}