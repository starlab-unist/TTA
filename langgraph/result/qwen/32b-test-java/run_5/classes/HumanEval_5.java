import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HumanEval_5 {

    // Source Code
    static class SourceCode {
        public static List<Integer> intersperse(List<Integer> numbers, int delimiter) {
            if (numbers.isEmpty()) {
                return new ArrayList<>();
            }

            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < numbers.size() - 1; i++) {
                result.add(numbers.get(i));
                result.add(delimiter);
            }

            result.add(numbers.get(numbers.size() - 1));

            return result;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static List<Integer> weaveNumbers(List<Integer> sequence, int separator) {
            if (sequence.isEmpty()) {
                return new ArrayList<>();
            }

            List<Integer> interleaved = new ArrayList<>();
            int index = 0;

            while (index < sequence.size() - 1) {
                interleaved.add(sequence.get(index));
                interleaved.add(separator);
                index++;
            }

            interleaved.add(sequence.get(sequence.size() - 1));

            return interleaved;
        }
    }

    // Test Cases
    @Test
    public void testIntersperseAndWeaveNumbers_WithMultipleElements() {
        assertEquals(SourceCode.intersperse(Arrays.asList(1, 2, 3), 0),
                     TransformedCode.weaveNumbers(Arrays.asList(1, 2, 3), 0));
    }

    @Test
    public void testIntersperseAndWeaveNumbers_WithNegativeDelimiter() {
        assertEquals(SourceCode.intersperse(Arrays.asList(5, 6, 7, 8), -1),
                     TransformedCode.weaveNumbers(Arrays.asList(5, 6, 7, 8), -1));
    }

    @Test
    public void testIntersperseAndWeaveNumbers_WithSingleElement() {
        assertEquals(SourceCode.intersperse(Arrays.asList(10), 5),
                     TransformedCode.weaveNumbers(Arrays.asList(10), 5));
    }

    @Test
    public void testIntersperseAndWeaveNumbers_WithEmptyList() {
        assertEquals(SourceCode.intersperse(new ArrayList<>(), 3),
                     TransformedCode.weaveNumbers(new ArrayList<>(), 3));
    }

    @Test
    public void testIntersperseAndWeaveNumbers_WithRepeatedElements() {
        assertEquals(SourceCode.intersperse(Arrays.asList(1, 1, 1, 1), 2),
                     TransformedCode.weaveNumbers(Arrays.asList(1, 1, 1, 1), 2));
    }

    @Test
    public void testIntersperseAndWeaveNumbers_WithDecreasingElements() {
        assertEquals(SourceCode.intersperse(Arrays.asList(9, 8, 7), 4),
                     TransformedCode.weaveNumbers(Arrays.asList(9, 8, 7), 4));
    }

    @Test
    public void testIntersperseAndWeaveNumbers_WithEvenElements() {
        assertEquals(SourceCode.intersperse(Arrays.asList(2, 4, 6, 8, 10), 1),
                     TransformedCode.weaveNumbers(Arrays.asList(2, 4, 6, 8, 10), 1));
    }

    @Test
    public void testIntersperseAndWeaveNumbers_WithIdenticalElementsAndDelimiter() {
        assertEquals(SourceCode.intersperse(Arrays.asList(3, 3, 3), 3),
                     TransformedCode.weaveNumbers(Arrays.asList(3, 3, 3), 3));
    }

    @Test
    public void testIntersperseAndWeaveNumbers_WithSingleUniqueElement() {
        assertEquals(SourceCode.intersperse(Arrays.asList(5), 5),
                     TransformedCode.weaveNumbers(Arrays.asList(5), 5));
    }

    @Test
    public void testIntersperseAndWeaveNumbers_WithTwoElements() {
        assertEquals(SourceCode.intersperse(Arrays.asList(7, 8), 9),
                     TransformedCode.weaveNumbers(Arrays.asList(7, 8), 9));
    }

    // Additional Simple Test Cases
    @Test
    public void testIntersperseAndWeaveNumbers_WithOneElement() {
        assertEquals(SourceCode.intersperse(Arrays.asList(1), 0),
                     TransformedCode.weaveNumbers(Arrays.asList(1), 0));
    }

    @Test
    public void testIntersperseAndWeaveNumbers_WithTwoDifferentElements() {
        assertEquals(SourceCode.intersperse(Arrays.asList(2, 3), 5),
                     TransformedCode.weaveNumbers(Arrays.asList(2, 3), 5));
    }

    @Test
    public void testIntersperseAndWeaveNumbers_WithThreeDifferentElements() {
        assertEquals(SourceCode.intersperse(Arrays.asList(4, 5, 6), 7),
                     TransformedCode.weaveNumbers(Arrays.asList(4, 5, 6), 7));
    }

    @Test
    public void testIntersperseAndWeaveNumbers_WithZeroElements() {
        assertEquals(SourceCode.intersperse(new ArrayList<>(), 8),
                     TransformedCode.weaveNumbers(new ArrayList<>(), 8));
    }

    @Test
    public void testIntersperseAndWeaveNumbers_WithNegativeElement() {
        assertEquals(SourceCode.intersperse(Arrays.asList(-1, -2), 3),
                     TransformedCode.weaveNumbers(Arrays.asList(-1, -2), 3));
    }

    @Test
    public void testIntersperseAndWeaveNumbers_WithLargeDelimiter() {
        assertEquals(SourceCode.intersperse(Arrays.asList(100, 200), 999),
                     TransformedCode.weaveNumbers(Arrays.asList(100, 200), 999));
    }

    @Test
    public void testIntersperseAndWeaveNumbers_WithLargeNumber() {
        assertEquals(SourceCode.intersperse(Arrays.asList(Integer.MAX_VALUE), 0),
                     TransformedCode.weaveNumbers(Arrays.asList(Integer.MAX_VALUE), 0));
    }
}