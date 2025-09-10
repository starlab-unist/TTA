import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_126 {

    // Source Code
    static class HumanEval_126_Source {
        public static boolean isSorted(List<Integer> lst) {
            HashMap<Integer, Integer> countDigit = new HashMap<>();
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

    // Transformed Code
    static class HumanEval_126_Transformed {
        public boolean checkSortedSequence(int[] sequence) {
            HashMap<Integer, Integer> digitCount = new HashMap<>();
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

    // Test Cases
    private static final Integer[][] testCases = {
        {1, 2, 3, 4, 5},
        {5, 4, 3, 2, 1},
        {1, 1, 2, 2, 3, 3},
        {1, 1, 1, 2, 3},
        {1},
        {},
        {1, 2, 2, 3, 4, 5, 5},
        {10, 9, 8, 7, 6, 5},
        {1, 2, 3, 3, 3, 4, 5},
        {1, 2, 3, 4, 5, 5, 5}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void isSorted_vs_checkSortedSequence(Integer[] inputArray) {
        List<Integer> inputList = Arrays.asList(inputArray);
        boolean sourceResult = HumanEval_126_Source.isSorted(inputList);
        boolean transformedResult = new HumanEval_126_Transformed().checkSortedSequence(Arrays.stream(inputArray).mapToInt(i -> i).toArray());
        assertEquals(sourceResult, transformedResult);
    }
}