import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HumanEval_20 {

    // Source Code
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

    // Transformed Code
    public static Tuple<Float, Float> determineNearestPair(List<Float> values) {
        Tuple<Float, Float> nearestPair = null;
        Float minGap = null;

        int index = 0;
        while (index < values.size()) {
            int innerIndex = 0;
            while (innerIndex < values.size()) {
                if (index != innerIndex) {
                    float currentDifference = Math.abs(values.get(index) - values.get(innerIndex));
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

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Tuple<?, ?> tuple = (Tuple<?, ?>) obj;
            return x.equals(tuple.x) && y.equals(tuple.y);
        }

        @Override
        public int hashCode() {
            int result = x.hashCode();
            result = 31 * result + y.hashCode();
            return result;
        }
    }

    // Test Cases
    private static final List<Double>[] testCases = new List[]{
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
    };

    @Test
    public void test_0() {
        assertEquals(findClosestElements(testCases[0]), determineNearestPair(convertToFloatList(testCases[0])));
    }

    @Test
    public void test_1() {
        assertEquals(findClosestElements(testCases[1]), determineNearestPair(convertToFloatList(testCases[1])));
    }

    @Test
    public void test_2() {
        assertEquals(findClosestElements(testCases[2]), determineNearestPair(convertToFloatList(testCases[2])));
    }

    @Test
    public void test_3() {
        assertEquals(findClosestElements(testCases[3]), determineNearestPair(convertToFloatList(testCases[3])));
    }

    @Test
    public void test_4() {
        assertEquals(findClosestElements(testCases[4]), determineNearestPair(convertToFloatList(testCases[4])));
    }

    @Test
    public void test_5() {
        assertEquals(findClosestElements(testCases[5]), determineNearestPair(convertToFloatList(testCases[5])));
    }

    @Test
    public void test_6() {
        assertEquals(findClosestElements(testCases[6]), determineNearestPair(convertToFloatList(testCases[6])));
    }

    @Test
    public void test_7() {
        assertEquals(findClosestElements(testCases[7]), determineNearestPair(convertToFloatList(testCases[7])));
    }

    @Test
    public void test_8() {
        assertEquals(findClosestElements(testCases[8]), determineNearestPair(convertToFloatList(testCases[8])));
    }

    @Test
    public void test_9() {
        // This case should handle the scenario where there is only one element in the list.
        // The function should return null as there are no pairs to compare.
        assertNull(findClosestElements(testCases[9]));
        assertNull(determineNearestPair(convertToFloatList(testCases[9])));
    }

    private List<Float> convertToFloatList(List<Double> doubleList) {
        return doubleList.stream().map(Double::floatValue).collect(java.util.stream.Collectors.toList());
    }
}