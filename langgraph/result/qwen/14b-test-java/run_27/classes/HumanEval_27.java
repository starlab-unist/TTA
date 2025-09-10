// Import statements must be declared outside of any class HumanEval_27.
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;  // Added import statement for Arrays class
import java.util.stream.Stream;

// Source Code and Transformed Code classes
class equiv_test_27 {

    static class SourceCode {
        public static String flipCase(String string) {
            StringBuilder result = new StringBuilder();
            for (char c : string.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    result.append(Character.toLowerCase(c));
                } else {
                    result.append(Character.toUpperCase(c));
                }
            }
            return result.toString();
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static String invertCharacterCase(String inputText) {
            StringBuilder result = new StringBuilder();
            for (char c : inputText.toCharArray()) {
                if (Character.isLowerCase(c)) {
                    result.append(Character.toUpperCase(c));
                } else if (Character.isUpperCase(c)) {
                    result.append(Character.toLowerCase(c));
                } else {
                    result.append(c);
                }
            }
            return result.toString();
        }
    }

    private static final String[] testCases = {
        "Hello World",
        "Python3.8",
        "1234567890",
        "FLIPCASEflipcase",
        "aBcDeFgHiJkLmNoPqRsTuVwXyZ",
        "!@#$%^&*()_+",
        "ALLCAPS",
        "alllower",
        "MiXeD CaSe",
        ""
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("flipCase vs invertCharacterCase Test")
    void flipCase_vs_invertCharacterCase(String inputText) {
        assertEquals(
            SourceCode.flipCase(inputText),
            TransformedCode.invertCharacterCase(inputText)
        );
    }
}