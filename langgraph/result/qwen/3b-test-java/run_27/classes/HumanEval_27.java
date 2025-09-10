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

public class HumanEval_27 {

    // Original Implementation (assuming we need to implement flipCase method)
    public static class OriginalImpl {
        public static String flipCase(String string) {
            StringBuilder result = new StringBuilder();
            for (char charAt : string.toCharArray()) {
                if (Character.isLowerCase(charAt)) {
                    result.append(Character.toUpperCase(charAt));
                } else if (Character.isUpperCase(charAt)) {
                    result.append(Character.toLowerCase(charAt));
                } else {
                    result.append(charAt);
                }
            }
            return result.toString();
        }
    }

    // Transformed Implementation
    public static class TransformedImpl {
        public static String invertCharacterCase(String inputText) {
            StringBuilder result = new StringBuilder();
            for (char charAt : inputText.toCharArray()) {
                if (Character.isLowerCase(charAt)) {
                    result.append(Character.toUpperCase(charAt));
                } else if (Character.isUpperCase(charAt)) {
                    result.append(Character.toLowerCase(charAt));
                } else {
                    result.append(charAt);
                }
            }
            return result.toString();
        }
    }

    // Test Inputs
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of("Hello World"),
            Arguments.of("Python3.8"),
            Arguments.of("1234567890"),
            Arguments.of("FLIPCASEflipcase"),
            Arguments.of("aBcDeFgHiJkLmNoPqRsTuVwXyZ"),
            Arguments.of("!@#$%^&*()_+"),
            Arguments.of("ALLCAPS"),
            Arguments.of("alllower"),
            Arguments.of("MiXeD CaSe"),
            Arguments.of("")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testFlipCaseAndInvertCharacterCase(String input) {
        String originalResult = OriginalImpl.flipCase(input);
        String transformedResult = TransformedImpl.invertCharacterCase(input);
        assertEquals(originalResult, transformedResult, "Mismatch for input: " + input);
    }
}