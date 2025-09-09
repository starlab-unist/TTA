import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_93 {

    // Source Code
    static class HumanEval_93_Source {
        public static String encode(String message) {
            String vowels = "aeiouAEIOU";
            Map<Character, Character> vowelsReplace = new HashMap<>();
            for (char i : vowels.toCharArray()) {
                vowelsReplace.put(i, (char) (i + 2));
            }
            StringBuilder encodedMessage = new StringBuilder();
            for (char i : message.toCharArray()) {
                char swappedChar = Character.isUpperCase(i) ? Character.toLowerCase(i) : Character.toUpperCase(i);
                encodedMessage.append(vowelsReplace.getOrDefault(swappedChar, swappedChar));
            }
            return encodedMessage.toString();
        }
    }

    // Transformed Code
    static class HumanEval_93_Transformed {
        public String transformMessage(String inputText) {
            String vowelSet = "aeiouAEIOU";
            StringBuilder result = new StringBuilder();

            for (char c : inputText.toCharArray()) {
                char mappedChar = Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
                if (vowelSet.indexOf(mappedChar) != -1) {
                    mappedChar = (char) (mappedChar + 2);
                }
                result.append(mappedChar);
            }

            return result.toString();
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "Hello World",
        "Python Programming",
        "OpenAI",
        "encode",
        "AEIOUaeiou",
        "1234567890",
        "Symbols #$%^&*()",
        "Mixed CASE",
        "aBcDeFgHiJkLmNoPqRsTuVwXyZ",
        ""
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void encode_vs_transformMessage(String inputText) {
        assertEquals(
            HumanEval_93_Source.encode(inputText),
            new HumanEval_93_Transformed().transformMessage(inputText)
        );
    }
}