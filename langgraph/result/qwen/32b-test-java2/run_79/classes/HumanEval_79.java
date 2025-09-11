import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Source Code
class OriginalImpl {
    public static String decimalToBinary(int decimal) {
        return "db" + Integer.toBinaryString(decimal) + "db";
    }
}

// Transformed Code
class TransformedImpl {
    public static String convertDecimalToBinary(int number) {
        String binaryRepresentation = Integer.toBinaryString(number);
        return "db" + binaryRepresentation + "db";
    }
}

public class HumanEval_79 {

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.arguments(0),
            Arguments.arguments(1),
            Arguments.arguments(2),
            Arguments.arguments(5),
            Arguments.arguments(10),
            Arguments.arguments(15),
            Arguments.arguments(32),
            Arguments.arguments(64),
            Arguments.arguments(255),
            Arguments.arguments(1023)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testDecimalToBinary(int decimal) {
        assertEquals(OriginalImpl.decimalToBinary(decimal), 
                     TransformedImpl.convertDecimalToBinary(decimal));
    }
}