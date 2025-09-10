// Import statements should be at the top
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.stream.Stream;

public class HumanEval_72 {

    // Source Code
    static class SourceCode {
        public static boolean willItFly(int[] q, int w) {
            if (sumArray(q) > w) {
                return false;
            }

            int i = 0, j = q.length - 1;
            while (i < j) {
                if (q[i] != q[j]) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }

        private static int sumArray(int[] array) {
            int sum = 0;
            for (int num : array) {
                sum += num;
            }
            return sum;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public boolean canItTakeOff(int[] weights, int maxWeight) {
            int totalWeight = 0;
            for (int weight : weights) {
                totalWeight += weight;
            }

            if (totalWeight > maxWeight) {
                return false;
            }

            int start = 0, end = weights.length - 1;
            while (start < end) {
                if (weights[start] != weights[end]) {
                    return false;
                }
                start++;
                end--;
            }

            return true;
        }
    }

    // Test Cases
    private static final Arguments[] testCases = {
        Arguments.of(new int[]{1, 2, 3, 2, 1}, 10),
        Arguments.of(new int[]{1, 2, 3, 4, 5}, 15),
        Arguments.of(new int[]{1, 1, 1, 1}, 4),
        Arguments.of(new int[]{1, 2, 2, 1}, 6),
        Arguments.of(new int[]{1}, 1),
        Arguments.of(new int[]{}, 0),
        Arguments.of(new int[]{5, 5, 5, 5}, 20),
        Arguments.of(new int[]{5, 5, 5, 5}, 19),
        Arguments.of(new int[]{1, 2, 3, 4, 3, 2, 1}, 20),
        Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 28)
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void willItFly_vs_canItTakeOff(int[] inputArray, int maxWeight) {
        assertEquals(
            SourceCode.willItFly(inputArray, maxWeight),
            new TransformedCode().canItTakeOff(inputArray, maxWeight)
        );
    }
}