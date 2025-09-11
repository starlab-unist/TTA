import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_20 {

    // Source Code
    static class OriginalImpl {
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
    static class TransformedImpl {
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
                            java.util.Collections.sort(nearestPair);
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
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(List.of(1.0, 2.0, 3.0, 4.0)),
            Arguments.of(List.of(5.5, 3.3, 2.2, 8.8, 9.9)),
            Arguments.of(List.of(-1.0, -2.0, -3.0, -4.0)),
            Arguments.of(List.of(10.0, 10.0, 10.0, 10.0)),
            Arguments.of(List.of(0.1, 0.2, 0.3, 0.4, 0.5)),
            Arguments.of(List.of(100.0, 99.0, 101.0, 98.0)),
            Arguments.of(List.of(0.0, 0.0, 0.0, 0.0)),
            Arguments.of(List.of(1.5, 2.5, 3.5, 4.5)),
            Arguments.of(List.of(1000.1, 1000.2, 999.9, 1001.1)),
            Arguments.of(List.of(1.0))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testClosestElements(List<Double> numbers) {
        List<Double> originalResult = OriginalImpl.findClosestElements(numbers);
        List<Double> transformedResult = TransformedImpl.determineNearestPair(numbers);

        assertEquals(originalResult, transformedResult);
    }
}