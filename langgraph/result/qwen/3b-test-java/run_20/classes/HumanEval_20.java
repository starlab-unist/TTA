import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_20 {

    // Source Code
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
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Tuple tuple = (Tuple) obj;
            return Double.compare(tuple.first, first) == 0 &&
                   Double.compare(tuple.second, second) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }

    // Transformed Code
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

    // Tuple class for the transformed code
    public static class Tuple<X, Y> {
        public final X x;
        public final Y y;

        public Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Tuple<?, ?> tuple = (Tuple<?, ?>) obj;
            return Objects.equals(x, tuple.x) && Objects.equals(y, tuple.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    // Test Class
    public static class HumanEval_20_Test {

        private static Stream<Arguments> provideTestCases() {
            return Stream.of(
                Arguments.of(Arrays.asList(1.0, 2.0, 3.0, 4.0)),
                Arguments.of(Arrays.asList(5.5, 3.3, 2.2, 8.8, 9.9)),
                Arguments.of(Arrays.asList(-1.0, -2.0, -3.0, -4.0)),
                Arguments.of(Arrays.asList(10.0, 10.0, 10.0, 10.0)),
                Arguments.of(Arrays.asList(0.1, 0.2, 0.3, 0.4, 0.5)),
                Arguments.of(Arrays.asList(100.0, 99.0, 101.0, 98.0)),
                Arguments.of(Arrays.asList(0.0, 0.0, 0.0, 0.0)),
                Arguments.of(Arrays.asList(1.5, 2.5, 3.5, 4.5)),
                Arguments.of(Arrays.asList(1000.1, 1000.2, 999.9, 1001.1)),
                Arguments.of(Arrays.asList(1.0))
            );
        }

        @ParameterizedTest
        @MethodSource("provideTestCases")
        public void test(List<Double> numbers) {
            assertEquals(findClosestElements(numbers), determineNearestPair(numbers));
        }
    }
}