import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import java.util.Arrays;

public class HumanEval_79 {

    // Source Code
    static class SourceCode {
        public static String decimalToBinary(int decimal) {
            return "db" + Integer.toBinaryString(decimal) + "db";
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static String convertDecimalToBinary(int number) {
            String binaryRepresentation = Integer.toBinaryString(number);
            return "db" + binaryRepresentation + "db";
        }
    }

    // Test Cases
    private static final int[] testCases = {
        0,
        1,
        2,
        5,
        10,
        15,
        32,
        64,
        255,
        1023
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(i -> Arguments.of(i));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void decimalToBinary_vs_convertDecimalToBinary(int inputNumber) {
        assertEquals(
            SourceCode.decimalToBinary(inputNumber),
            TransformedCode.convertDecimalToBinary(inputNumber)
        );
    }
}