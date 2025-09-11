import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HumanEval_20 {

    // Source Code
    public static class Pair<T, U> {
        private final T first;
        private final U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair<?, ?> pair = (Pair<?, ?>) o;

            if (!first.equals(pair.first)) return false;
            return second.equals(pair.second);
        }

        @Override
        public int hashCode() {
            int result = first.hashCode();
            result = 31 * result + second.hashCode();
            return result;
        }
    }

    static class HumanEval_20_Source {
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

    // Transformed Code
    static class HumanEval_20_Transformed {
        public static double[] determineNearestPair(List<Double> values) {
            double[] nearestPair = null;
            double minGap = Double.MAX_VALUE;

            int index = 0;
            while (index < values.size()) {
                int innerIndex = 0;
                while (innerIndex < values.size()) {
                    if (index != innerIndex) {
                        double currentDifference = Math.abs(values.get(index) - values.get(innerIndex));
                        if (currentDifference < minGap) {
                            minGap = currentDifference;
                            nearestPair = Arrays.stream(new Double[]{values.get(index), values.get(innerIndex)})
                                            .sorted()
                                            .mapToDouble(Double::doubleValue)
                                            .toArray();
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
    private static final Object[][] testCases = {
        {Arrays.asList(1.0, 2.0, 3.0, 4.0)},
        {Arrays.asList(5.5, 3.3, 2.2, 8.8, 9.9)},
        {Arrays.asList(-1.0, -2.0, -3.0, -4.0)},
        {Arrays.asList(10.0, 10.0, 10.0, 10.0)},
        {Arrays.asList(0.1, 0.2, 0.3, 0.4, 0.5)},
        {Arrays.asList(100.0, 99.0, 101.0, 98.0)},
        {Arrays.asList(0.0, 0.0, 0.0, 0.0)},
        {Arrays.asList(1.5, 2.5, 3.5, 4.5)},
        {Arrays.asList(1000.1, 1000.2, 999.9, 1001.1)},
        {Arrays.asList(1.0)}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_20_Source.findClosestElements((List<Double>) testCases[0][0]), 
                     HumanEval_20_Transformed.determineNearestPair((List<Double>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_20_Source.findClosestElements((List<Double>) testCases[1][0]), 
                     HumanEval_20_Transformed.determineNearestPair((List<Double>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_20_Source.findClosestElements((List<Double>) testCases[2][0]), 
                     HumanEval_20_Transformed.determineNearestPair((List<Double>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_20_Source.findClosestElements((List<Double>) testCases[3][0]), 
                     HumanEval_20_Transformed.determineNearestPair((List<Double>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_20_Source.findClosestElements((List<Double>) testCases[4][0]), 
                     HumanEval_20_Transformed.determineNearestPair((List<Double>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_20_Source.findClosestElements((List<Double>) testCases[5][0]), 
                     HumanEval_20_Transformed.determineNearestPair((List<Double>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_20_Source.findClosestElements((List<Double>) testCases[6][0]), 
                     HumanEval_20_Transformed.determineNearestPair((List<Double>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_20_Source.findClosestElements((List<Double>) testCases[7][0]), 
                     HumanEval_20_Transformed.determineNearestPair((List<Double>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_20_Source.findClosestElements((List<Double>) testCases[8][0]), 
                     HumanEval_20_Transformed.determineNearestPair((List<Double>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        // This case should handle the scenario where there is only one element in the list.
        // The function should return null as there are no pairs to compare.
        assertNull(HumanEval_20_Source.findClosestElements((List<Double>) testCases[9][0]));
        assertNull(HumanEval_20_Transformed.determineNearestPair((List<Double>) testCases[9][0]));
    }
}