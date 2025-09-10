// Source Code
class SourceCode {
    public String decimalToBinary(int decimal) {
        return "db" + Integer.toBinaryString(decimal) + "db";
    }
}

// Transformed Code
class TransformedCode {
    public String convertDecimalToBinary(int number) {
        String binaryRepresentation = Integer.toBinaryString(number);
        return "db" + binaryRepresentation + "db";
    }
}

// Test Cases
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import java.util.Arrays;  // Added import for Arrays

public class HumanEval_79 {

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
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @DisplayName("Test equivalence of decimalToBinary and convertDecimalToBinary")
    @ParameterizedTest(name = "Test case {index}: input={0}")
    @MethodSource("provideTestCases")
    void decimalToBinary_vs_convertDecimalToBinary(int inputNumber) {
        SourceCode sourceCodeInstance = new SourceCode();
        TransformedCode transformedCodeInstance = new TransformedCode();

        assertEquals(
            sourceCodeInstance.decimalToBinary(inputNumber),
            transformedCodeInstance.convertDecimalToBinary(inputNumber)
        );
    }
}