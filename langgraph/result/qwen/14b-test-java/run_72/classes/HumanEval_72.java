import java.util.*;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_72 {

    // Source Code
    static class SourceCode {
        public static boolean willItFly(int[] q, int w) {
            int sum = 0;
            for (int num : q) {
                sum += num;
            }
            if (sum > w) {
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
    }

    // Transformed Code
    static class TransformedCode {
        public static boolean can_it_take_off(int[] weights, int max_weight) {
            int total_weight = 0;
            for (int weight : weights) {
                total_weight += weight;
            }

            if (total_weight > max_weight) {
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
    private static final Arguments[][] testCases = {
        {Arguments.of(new int[]{1, 2, 3, 2, 1}, 10)},
        {Arguments.of(new int[]{1, 2, 3, 4, 5}, 15)},
        {Arguments.of(new int[]{1, 1, 1, 1}, 4)},
        {Arguments.of(new int[]{1, 2, 2, 1}, 6)},
        {Arguments.of(new int[]{1}, 1)},
        {Arguments.of(new int[]{}, 0)},
        {Arguments.of(new int[]{5, 5, 5, 5}, 20)},
        {Arguments.of(new int[]{5, 5, 5, 5}, 19)},
        {Arguments.of(new int[]{1, 2, 3, 4, 3, 2, 1}, 20)},
        {Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 28)}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(args -> args[0]);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void willItFly_vs_can_it_take_off(Arguments arguments) {
        int[] weights = (int[]) arguments.get()[0];
        int max_weight = (int) arguments.get()[1];

        assertEquals(
            SourceCode.willItFly(weights, max_weight),
            TransformedCode.can_it_take_off(weights, max_weight)
        );
    }
}