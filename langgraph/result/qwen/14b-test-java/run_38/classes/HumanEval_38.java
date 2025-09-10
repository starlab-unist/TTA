import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_38 {

    // Source Code
    static class HumanEval_38_Source {
        public static String encodeCyclic(String s) {
            // split string to groups. Each of length 3.
            StringBuilder encoded = new StringBuilder();
            for (int i = 0; i < s.length(); i += 3) {
                String group = s.substring(i, Math.min(i + 3, s.length()));
                // cycle elements in each group. Unless group has fewer elements than 3.
                if (group.length() == 3) {
                    group = group.substring(1) + group.charAt(0);
                }
                encoded.append(group);
            }
            return encoded.toString();
        }

        public static String decodeCyclic(String s) {
            return encodeCyclic(encodeCyclic(s));
        }
    }

    // Transformed Code
    static class HumanEval_38_Transformed {
        public static String transformCyclicString(String inputString) {
            // Divide the string into chunks of three characters
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < inputString.length(); i += 3) {
                String chunk = inputString.substring(i, Math.min(i + 3, inputString.length()));
                
                // Rotate each chunk if it contains exactly three characters
                if (chunk.length() == 3) {
                    chunk = chunk.substring(1) + chunk.charAt(0);
                }
                
                // Append the chunk to the result
                result.append(chunk);
            }
            
            return result.toString();
        }

        public static String reverseCyclicTransformation(String encodedString) {
            // Apply the transformation twice to decode the string
            return transformCyclicString(transformCyclicString(encodedString));
        }
    }

    // Test Cases
    private static final String[][] testCases = {
        {"abcdef"},
        {"hello world"},
        {"abcde"},
        {"a"},
        {""},
        {"python"},
        {"123456789"},
        {"transform"},
        {"cyclic"},
        {"unittest"}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Check if both functions produce the same output for the given inputs")
    void encodeCyclic_vs_transformCyclicString(String inputText) {
        assertEquals(
            HumanEval_38_Source.encodeCyclic(inputText),
            HumanEval_38_Transformed.transformCyclicString(inputText)
        );
    }
}