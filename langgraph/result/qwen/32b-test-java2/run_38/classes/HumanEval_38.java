import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Importing necessary classes for Stream and Arrays
import java.util.stream.Stream;
import java.util.Arrays;

public class HumanEval_38 {

    // Source Code
    static class SourceCode {
        public static String encodeCyclic(String s) {
            StringBuilder encoded = new StringBuilder();
            int length = s.length();

            for (int i = 0; i < length; i += 3) {
                String group = s.substring(i, Math.min(i + 3, length));
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
    static class TransformedCode {
        /**
         * Returns encoded string by cycling groups of three characters.
         */
        public static String transformCyclicString(String inputString) {
            // Divide the string into chunks of three characters
            StringBuilder[] chunks = new StringBuilder[(inputString.length() + 2) / 3];
            for (int i = 0; i < inputString.length(); i += 3) {
                chunks[i / 3] = new StringBuilder(inputString.substring(i, Math.min(i + 3, inputString.length())));
            }

            // Rotate each chunk if it contains exactly three characters
            for (int i = 0; i < chunks.length; i++) {
                if (chunks[i].length() == 3) {
                    char firstChar = chunks[i].charAt(0);
                    chunks[i].deleteCharAt(0);
                    chunks[i].append(firstChar);
                }
            }

            // Join all chunks back into a single string
            StringBuilder result = new StringBuilder();
            for (StringBuilder chunk : chunks) {
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
    private static final String[] testCases = {
        "abcdef",
        "hello world",
        "abcde",
        "a",
        "",
        "python",
        "123456789",
        "transform",
        "cyclic",
        "unittest"
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Testing encodeCyclic vs transformCyclicString")
    void testEncodeCyclic_vs_TransformCyclicString(String inputText) {
        assertEquals(
            SourceCode.encodeCyclic(inputText),
            TransformedCode.transformCyclicString(inputText)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Testing decodeCyclic vs reverseCyclicTransformation")
    void testDecodeCyclic_vs_ReverseCyclicTransformation(String inputText) {
        assertEquals(
            SourceCode.decodeCyclic(inputText),
            TransformedCode.reverseCyclicTransformation(inputText)
        );
    }
}