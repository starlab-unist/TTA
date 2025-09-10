import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HumanEval_20 {

    // Source Code
    static class HumanEval_20_Source {
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

    // Transformed Code
    static class HumanEval_20_Transformed {
        public static List<Double> determineNearestPair(List<Double> values) {
            List<Double> nearestPair = null;
            Double minGap = null;

            int index = 0;
            while (index < values.size()) {
                int innerIndex = 0;
                while (innerIndex < values.size()) {
                    if (index != innerIndex) {
                        Double currentDifference = Math.abs(values.get(index) - values.get(innerIndex));
                        if (minGap == null || currentDifference < minGap) {
                            minGap = currentDifference;
                            nearestPair = new ArrayList<>(List.of(values.get(index), values.get(innerIndex)));
                            Collections.sort(nearestPair);
                        }
                    }
                    innerIndex += 1;
                }
                index += 1;
            }

            return nearestPair;
        }
    }

    // Test Cases
    private static final List<List<Double>> testCases = Arrays.asList(
        new ArrayList<>(List.of(1.0, 2.0, 3.0, 4.0)),
        new ArrayList<>(List.of(5.5, 3.3, 2.2, 8.8, 9.9)),
        new ArrayList<>(List.of(-1.0, -2.0, -3.0, -4.0)),
        new ArrayList<>(List.of(10.0, 10.0, 10.0, 10.0)),
        new ArrayList<>(List.of(0.1, 0.2, 0.3, 0.4, 0.5)),
        new ArrayList<>(List.of(100.0, 99.0, 101.0, 98.0)),
        new ArrayList<>(List.of(0.0, 0.0, 0.0, 0.0)),
        new ArrayList<>(List.of(1.5, 2.5, 3.5, 4.5)),
        new ArrayList<>(List.of(1000.1, 1000.2, 999.9, 1001.1)),
        new ArrayList<>(List.of(1.0))
    );

    private static Stream<Arguments> provideTestCases() {
        return testCases.stream().map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void findClosestElements_vs_determineNearestPair(List<Double> inputList) {
        List<Double> sourceResult = HumanEval_20_Source.findClosestElements(inputList);
        List<Double> transformedResult = HumanEval_20_Transformed.determineNearestPair(inputList);

        if (inputList.size() == 1) {
            assertNull(sourceResult);
            assertNull(transformedResult);
        } else {
            assertEquals(sourceResult, transformedResult);
        }
    }
}