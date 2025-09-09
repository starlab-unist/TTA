import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_126 {

    // Source Code
    static class HumanEval_126 {
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
            Map<Integer, Integer> digitCount = new HashMap<>();
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
    private static final List<List<Integer>> testCases = Arrays.asList(
        Arrays.asList(1, 2, 3, 4, 5),
        Arrays.asList(5, 4, 3, 2, 1),
        Arrays.asList(1, 1, 2, 2, 3, 3),
        Arrays.asList(1, 1, 1, 2, 3),
        Arrays.asList(1),
        Arrays.asList(),
        Arrays.asList(1, 2, 2, 3, 4, 5, 5),
        Arrays.asList(10, 9, 8, 7, 6, 5),
        Arrays.asList(1, 2, 3, 3, 3, 4, 5),
        Arrays.asList(1, 2, 3, 4, 5, 5, 5)
    );

    private static Stream<Arguments> provideTestCases() {
        return testCases.stream().map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Check if both functions produce the same output for given inputs")
    void isSorted_vs_checkSortedSequence(List<Integer> inputList) {
        int[] inputArray = inputList.stream().mapToInt(i -> i).toArray();
        
        assertEquals(
            HumanEval_126.isSorted(inputList),
            new HumanEval_126_Transformed().checkSortedSequence(inputArray)
        );
    }
}