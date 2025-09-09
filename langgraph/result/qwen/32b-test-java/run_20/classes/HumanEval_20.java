import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_20 {

    // Source Code
    static class SourceCode {
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
    static class TransformedCode {
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
        }
    }

    // Test Cases based on the Python test cases provided
    private static final List<List<Double>> testCases = Arrays.asList(
        Arrays.asList(1.0, 2.0, 3.0, 4.0),
        Arrays.asList(5.5, 3.3, 2.2, 8.8, 9.9),
        Arrays.asList(-1.0, -2.0, -3.0, -4.0),
        Arrays.asList(10.0, 10.0, 10.0, 10.0),
        Arrays.asList(0.1, 0.2, 0.3, 0.4, 0.5),
        Arrays.asList(100.0, 99.0, 101.0, 98.0),
        Arrays.asList(0.0, 0.0, 0.0, 0.0),
        Arrays.asList(1.5, 2.5, 3.5, 4.5),
        Arrays.asList(1000.1, 1000.2, 999.9, 1001.1)
    );

    @Test
    public void test_0() {
        assertEquals(SourceCode.findClosestElements(testCases.get(0)).toString(), TransformedCode.determineNearestPair(toFloatList(testCases.get(0))).toString());
    }

    @Test
    public void test_1() {
        assertEquals(SourceCode.findClosestElements(testCases.get(1)).toString(), TransformedCode.determineNearestPair(toFloatList(testCases.get(1))).toString());
    }

    @Test
    public void test_2() {
        assertEquals(SourceCode.findClosestElements(testCases.get(2)).toString(), TransformedCode.determineNearestPair(toFloatList(testCases.get(2))).toString());
    }

    @Test
    public void test_3() {
        assertEquals(SourceCode.findClosestElements(testCases.get(3)), null);
        assertEquals(TransformedCode.determineNearestPair(toFloatList(testCases.get(3))), null);
    }

    @Test
    public void test_4() {
        assertEquals(SourceCode.findClosestElements(testCases.get(4)).toString(), TransformedCode.determineNearestPair(toFloatList(testCases.get(4))).toString());
    }

    @Test
    public void test_5() {
        assertEquals(SourceCode.findClosestElements(testCases.get(5)).toString(), TransformedCode.determineNearestPair(toFloatList(testCases.get(5))).toString());
    }

    @Test
    public void test_6() {
        assertEquals(SourceCode.findClosestElements(testCases.get(6)), null);
        assertEquals(TransformedCode.determineNearestPair(toFloatList(testCases.get(6))), null);
    }

    @Test
    public void test_7() {
        assertEquals(SourceCode.findClosestElements(testCases.get(7)).toString(), TransformedCode.determineNearestPair(toFloatList(testCases.get(7))).toString());
    }

    @Test
    public void test_8() {
        assertEquals(SourceCode.findClosestElements(testCases.get(8)).toString(), TransformedCode.determineNearestPair(toFloatList(testCases.get(8))).toString());
    }

    // Helper method to convert List<Double> to List<Float>
    private static List<Float> toFloatList(List<Double> doubleList) {
        return doubleList.stream().map(Double::floatValue).collect(Collectors.toList());
    }
}