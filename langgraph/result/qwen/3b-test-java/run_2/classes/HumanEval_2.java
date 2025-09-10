import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_2 {

    // Source Code Method
    public static double truncateNumber(double number) {
        return number % 1.0;
    }

    // Transformed Code Method
    public static float extractDecimalPart(float value) {
        float decimalPart = value - (int) value;
        return decimalPart;
    }
    
    // Test Cases Class
    public static class HumanEval_2_Test {

        // Nested static classes for the original and transformed implementations
        public static class OriginalImpl {
            public static double truncateNumber(double number) {
                return number % 1.0;
            }
        }

        public static class TransformedImpl {
            public static float extractDecimalPart(float value) {
                float decimalPart = value - (int) value;
                return decimalPart;
            }
        }

        // Method to provide test cases
        private static Stream<Arguments> provideTestCases() {
            return Stream.of(
                Arguments.of(3.14159),
                Arguments.of(0.99999),
                Arguments.of(123.456),
                Arguments.of(-789.123),
                Arguments.of(0.0),
                Arguments.of(-0.0),
                Arguments.of(100.0),
                Arguments.of(-100.0),
                Arguments.of(1.0),
                Arguments.of(-1.0)
            );
        }

        // Parameterized test method
        @ParameterizedTest
        @MethodSource("provideTestCases")
        public void testTruncateNumberAndExtractDecimalPart(double input) {
            double originalResult = OriginalImpl.truncateNumber(input);
            float transformedResult = TransformedImpl.extractDecimalPart((float) input);
            assertEquals(originalResult, transformedResult, 0.0001, "Input: " + input);
        }
    }
}