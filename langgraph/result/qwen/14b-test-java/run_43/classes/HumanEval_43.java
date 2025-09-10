import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays; // Import Arrays class
import java.util.stream.Stream; // Import Stream class

public class HumanEval_43 {

    // Source Code
    static class SourceCode {
        public static boolean pairsSumToZero(int[] l) {
            for (int i = 0; i < l.length; i++) {
                int l1 = l[i];
                for (int j = i + 1; j < l.length; j++) {
                    if (l1 + l[j] == 0) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static boolean check_for_zero_sum_pairs(int[] numbers) {
            int index = 0;
            while (index < numbers.length) {
                int current_number = numbers[index];
                int next_index = index + 1;
                while (next_index < numbers.length) {
                    if (current_number + numbers[next_index] == 0) {
                        return true;
                    }
                    next_index += 1;
                }
                index += 1;
            }
            return false;
        }
    }

    // Test Cases
    private static final Arguments[] testCases = {
        Arguments.of(new int[]{}, false),
        Arguments.of(new int[]{1, -1}, true),
        Arguments.of(new int[]{2, 3, -2}, true),
        Arguments.of(new int[]{0, 0}, true),
        Arguments.of(new int[]{5, 7, 9}, false),
        Arguments.of(new int[]{-5, -7, -9}, false),
        Arguments.of(new int[]{1, 2, 3, -3}, true),
        Arguments.of(new int[]{10, 20, -10, 30}, true),
        Arguments.of(new int[]{4, 5, 6, 7, 8}, false),
        Arguments.of(new int[]{0, 1, 2, 3, 4, 5, -5}, true)
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void pairsSumToZero_vs_check_for_zero_sum_pairs(int[] inputArray, boolean expected) {
        assertEquals(
            SourceCode.pairsSumToZero(inputArray),
            TransformedCode.check_for_zero_sum_pairs(inputArray)
        );
    }
}