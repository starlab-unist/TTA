import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;  // Import for ArrayList

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;  // Import for Stream

public class HumanEval_88 {

    // Source Code
    static class SourceCode {
        public static List<Integer> sortArray(List<Integer> array) {
            if (array.isEmpty()) {
                return Collections.emptyList();
            }
            boolean reverse = (array.get(0) + array.get(array.size() - 1)) % 2 == 0;
            if (reverse) {
                array.sort(Collections.reverseOrder());
            } else {
                Collections.sort(array);
            }
            return array;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public List<Integer> arrangeSequence(List<Integer> sequence) {
            if (sequence.isEmpty()) {
                return new ArrayList<>();
            }
            
            boolean reverseOrder = (sequence.get(0) + sequence.get(sequence.size() - 1)) % 2 == 0;
            List<Integer> sortedSequence = new ArrayList<>(sequence);
            Collections.sort(sortedSequence, reverseOrder ? Collections.reverseOrder() : null);
            return sortedSequence;
        }
    }

    // Test Cases
    private static final Integer[][] testCases = {
        {3, 1, 4, 1, 5, 9},
        {10, 20, 30, 40, 50},
        {5, 3, 8, 6, 7, 2},
        {7, 2, 9, 4, 6},
        {1},
        {},
        {2, 4, 6, 8, 10},
        {9, 7, 5, 3, 1},
        {11, 22, 33, 44, 55},
        {100, 200, 300, 400, 500}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void sortArray_vs_arrangeSequence(List<Integer> inputList) {
        assertEquals(
            SourceCode.sortArray(inputList),
            new TransformedCode().arrangeSequence(inputList)
        );
    }
}