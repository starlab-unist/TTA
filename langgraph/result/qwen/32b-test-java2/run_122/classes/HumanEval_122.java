// Source Code (HumanEval_122.java)
public class HumanEval_122 {
    public static int addElements(int[] arr, int k) {
        int sum = 0;
        for (int num : arr) {
            if (num < k) {
                sum += num;
            }
        }
        return sum;
    }
}

// Transformed Code (TransformedCode.java)
public class TransformedCode {
    public int calculateSumOfSmallNumbers(int[] arr, int k) {
        int sum = 0;
        for (int num : arr) {
            if (num < k) {
                sum += num;
            }
        }
        return sum;
    }
}

// Test Cases (equiv_test_0.java)
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class equiv_test_0 {

    private static final Object[][] testCases = {
        {new int[]{1, 10, 100, 1000}, 3},
        {new int[]{5, 23, 456, 7890}, 4},
        {new int[]{99, 100, 101, 102}, 2},
        {new int[]{1, 2, 3, 4, 5}, 5},
        {new int[]{123, 45, 67, 89, 10}, 5},
        {new int[]{111, 222, 333, 44, 55}, 3},
        {new int[]{1, 1, 1, 1, 1}, 1},
        {new int[]{}, 1},
        {new int[]{10, 20, 30, 40, 50}, 0},
        {new int[]{9, 8, 7, 6, 5}, 5}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(testCase -> Arguments.of((int[]) testCase[0], (int) testCase[1]));
    }

    @DisplayName("Check if both functions produce the same output for given inputs")
    @ParameterizedTest(name = "Input {index}: arr={0}, k={1}")
    @MethodSource("provideTestCases")
    void addElements_vs_calculateSumOfSmallNumbers(int[] inputArray, int k) {
        assertEquals(
            HumanEval_122.addElements(inputArray, k),
            new TransformedCode().calculateSumOfSmallNumbers(inputArray, k)
        );
    }
}