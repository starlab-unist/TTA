import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_27 {

    // Source Code
    public static class SourceCode {
        public static String flipCase(String string) {
            return string == null ? null : string.chars()
                .mapToObj(c -> Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        }
    }

    // Transformed Code
    public static class TransformedCode {
        public String invertCharacterCase(String inputText) {
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
    @DisplayName("Test equivalence of flipCase and invertCharacterCase")
    @ParameterizedTest(name = "{index} => input={0}")
    @ValueSource(strings = {
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
    })
    void testFlipCase_vs_InvertCharacterCase(String inputText) {
        assertEquals(
            SourceCode.flipCase(inputText),
            new TransformedCode().invertCharacterCase(inputText)
        );
    }
}