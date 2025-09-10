import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;  // Added import for Stream
import java.util.Arrays;       // Added import for Arrays

public class HumanEval_102 {

    // Source Code
    static class HumanEval_102_Source {
        public int chooseNum(int x, int y) {
            if (x > y) {
                return -1;
            }
            if (y % 2 == 0) {
                return y;
            }
            if (x == y) {
                return -1;
            }
            return y - 1;
        }
    }

    // Transformed Code
    static class HumanEval_102_Transformed {
        public int selectNumber(int a, int b) {
            if (a > b) {
                return -1;
            } else if (b % 2 == 0) {
                return b;
            } else if (a == b) {
                return -1;
            } else {
                return b - 1;
            }
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {3, 5},     // y > x and y is odd
        {4, 4},     // x == y
        {2, 6},     // y > x and y is even
        {7, 8},     // y > x and y is even
        {10, 10},   // x == y
        {5, 3},     // x > y
        {0, 2},     // y > x and y is even
        {1, 1},     // x == y
        {9, 11},    // y > x and y is odd
        {6, 7}      // y > x and y is odd
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void chooseNum_vs_selectNumber(int x, int y) {
        HumanEval_102_Source source = new HumanEval_102_Source();  // Create instance of Source class
        HumanEval_102_Transformed transformed = new HumanEval_102_Transformed();  // Create instance of Transformed class

        assertEquals(
            source.chooseNum(x, y),  // Use the instance to call chooseNum
            transformed.selectNumber(x, y)  // Use the instance to call selectNumber
        );
    }
}