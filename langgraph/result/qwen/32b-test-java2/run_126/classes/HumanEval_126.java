import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// Original Implementation
class HumanEval_126_Original {
    public static boolean isSorted(List<Integer> lst) {
        java.util.HashMap<Integer, Integer> countDigit = new java.util.HashMap<>();
        for (int i : lst) {
            countDigit.put(i, countDigit.getOrDefault(i, 0) + 1);
        }
        for (int i : lst) {
            if (countDigit.get(i) > 2) {
                return false;
            }
        }
        for (int i = 1; i < lst.size(); i++) {
            if (lst.get(i - 1) > lst.get(i)) {
                return false;
            }
        }
        return true;
    }
}

// Transformed Implementation
class HumanEval_126_Transformed {
    public static boolean checkSortedSequence(int[] sequence) {
        java.util.Map<Integer, Integer> digitCount = new java.util.HashMap<>();
        for (int num : sequence) {
            digitCount.put(num, digitCount.getOrDefault(num, 0) + 1);
        }
        
        for (int num : sequence) {
            if (digitCount.get(num) > 2) {
                return false;
            }
        }
        
        int index = 1;
        while (index < sequence.length) {
            if (sequence[index - 1] > sequence[index]) {
                return false;
            }
            index++;
        }
        
        return true;
    }
}

// Test Class
public class HumanEval_126 {

    // Nested Original Implementation
    static class OriginalImpl {
        public static boolean isSorted(List<Integer> lst) {
            return HumanEval_126_Original.isSorted(lst);
        }
    }

    // Nested Transformed Implementation
    static class TransformedImpl {
        public static boolean checkSortedSequence(int[] sequence) {
            return HumanEval_126_Transformed.checkSortedSequence(sequence);
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5)),
            Arguments.arguments(Arrays.asList(5, 4, 3, 2, 1)),
            Arguments.arguments(Arrays.asList(1, 1, 2, 2, 3, 3)),
            Arguments.arguments(Arrays.asList(1, 1, 1, 2, 3)),
            Arguments.arguments(Arrays.asList(1)),
            Arguments.arguments(Arrays.asList()),
            Arguments.arguments(Arrays.asList(1, 2, 2, 3, 4, 5, 5)),
            Arguments.arguments(Arrays.asList(10, 9, 8, 7, 6, 5)),
            Arguments.arguments(Arrays.asList(1, 2, 3, 3, 3, 4, 5)),
            Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5, 5, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testIsSorted(List<Integer> input) {
        int[] arrayInput = IntStream.of(input.stream().mapToInt(Integer::intValue).toArray()).toArray();
        boolean originalResult = OriginalImpl.isSorted(input);
        boolean transformedResult = TransformedImpl.checkSortedSequence(arrayInput);

        Assertions.assertEquals(originalResult, transformedResult);
    }
}