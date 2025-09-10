import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream; // Added import for Stream
import java.util.Arrays; // Added import for Arrays

public class HumanEval_14 {

    // Source Code
    static class HumanEval_14_Source {
        public static List<String> allPrefixes(String string) {
            List<String> result = new ArrayList<>();

            for (int i = 0; i < string.length(); i++) {
                result.add(string.substring(0, i + 1));
            }
            return result;
        }
    }

    // Transformed Code
    static class HumanEval_14_Transformed {
        public List<String> generateStringPrefixes(String inputStr) {
            List<String> prefixes = new ArrayList<>();
            int index = 0;

            while (index < inputStr.length()) {
                prefixes.add(inputStr.substring(0, index + 1));
                index++;
            }

            return prefixes;
        }
    }

    private static final String[] testCases = {
        "hello",
        "world",
        "a",
        "",
        "python",
        "unittest",
        "12345",
        "prefixes",
        "testcase",
        "semantics"
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void allPrefixes_vs_generateStringPrefixes(String inputText) {
        assertEquals(
            HumanEval_14_Source.allPrefixes(inputText),
            new HumanEval_14_Transformed().generateStringPrefixes(inputText)
        );
    }
}