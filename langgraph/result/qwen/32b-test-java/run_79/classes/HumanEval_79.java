import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_79 {

    // Source Code
    static class HumanEval_79_Source {
        public String decimalToBinary(int decimal) {
            return "db" + Integer.toBinaryString(decimal) + "db";
        }
    }

    // Transformed Code
    static class HumanEval_79_Transformed {
        public String convertDecimalToBinary(int number) {
            String binaryRepresentation = Integer.toBinaryString(number);
            return "db" + binaryRepresentation + "db";
        }
    }

    // Test Cases
    private static final int[] testCases = {0, 1, 2, 3, 4, 5, 10, 15, 16, 31, 32, 63, 64, 127, 128, 255, 256, 511, 512, 1023};

    @ParameterizedTest(name = "Input: {0}")
    @MethodSource("provideSimpleTestCases")
    public void decimalToBinary_vs_convertDecimalToBinary(int input) {
        assertEquals(
            new HumanEval_79_Source().decimalToBinary(input),
            new HumanEval_79_Transformed().convertDecimalToBinary(input)
        );
    }

    private static Stream<Arguments> provideSimpleTestCases() {
        // Include at least 10 simple test cases
        return Arrays.stream(new int[]{0, 1, 2, 3, 4, 5, 8, 16, 32, 64}).map(Arguments::of);
    }
}