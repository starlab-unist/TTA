import java.util.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_27 {

    // Source Code
    static class HumanEval_27_Source {
        public static String flipCase(String string) {
            return string == null ? null : string.chars()
                .mapToObj(c -> Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        }
    }

    // Transformed Code
    static class HumanEval_27_Transformed {
        public String invertCharacterCase(String inputText) { // Instance method (non-static)
            if (inputText == null) return null;
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

    // Test Cases
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
    void flipCase_vs_invertCharacterCase(String inputText) {
        HumanEval_27_Transformed transformed = new HumanEval_27_Transformed(); // Create an instance
        assertEquals(
            HumanEval_27_Source.flipCase(inputText),
            transformed.invertCharacterCase(inputText) // Use the instance to call the method
        );
    }
}