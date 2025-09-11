import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class HumanEval_57 {

    // Source Code
    static class OriginalImpl {
        public static boolean monotonic(List<Integer> l) {
            List<Integer> sortedList = new ArrayList<>(l);
            Collections.sort(sortedList);
            if (l.equals(sortedList) || l.equals(new ArrayList<>(sortedList).stream().sorted(Collections.reverseOrder()).toList())) {
                return true;
            }
            return false;
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public static boolean checkMonotonicSequence(List<Integer> sequence) {
            List<Integer> ascending = new ArrayList<>(sequence);
            List<Integer> descending = new ArrayList<>(sequence);
            
            Collections.sort(ascending);
            Collections.sort(descending, Collections.reverseOrder());
            
            if (sequence.equals(ascending) || sequence.equals(descending)) {
                return true;
            }
            return false;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 3, 4, 5)),       // strictly increasing
            Arguments.of(List.of(5, 4, 3, 2, 1)),       // strictly decreasing
            Arguments.of(List.of(1, 1, 1, 1, 1)),       // all elements are the same
            Arguments.of(List.of(1, 2, 2, 3, 4)),       // non-decreasing
            Arguments.of(List.of(5, 5, 4, 4, 3, 2, 1)), // non-increasing
            Arguments.of(List.of(1, 3, 2)),             // not monotonic
            Arguments.of(List.of()),                    // empty list
            Arguments.of(List.of(10)),                  // single element
            Arguments.of(List.of(3, 3, 2, 1, 1, 1)),    // decreasing with duplicates
            Arguments.of(List.of(1, 1, 2, 2, 3, 3))     // increasing with duplicates
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testMonotonic(List<Integer> input) {
        boolean originalResult = OriginalImpl.monotonic(input);
        boolean transformedResult = TransformedImpl.checkMonotonicSequence(input);
        Assertions.assertEquals(originalResult, transformedResult);
    }
}