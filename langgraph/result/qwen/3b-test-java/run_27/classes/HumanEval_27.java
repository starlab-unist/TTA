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

// Source Code
public class HumanEval_27 {

    // Nested static classes for original and transformed implementations
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

    // Provide test cases
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

    // Parameterized test
    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testFlipCaseAndInvertCharacterCase(String input) {
        assertEquals(OriginalImpl.flipCase(input), TransformedImpl.invertCharacterCase(input));
    }
}