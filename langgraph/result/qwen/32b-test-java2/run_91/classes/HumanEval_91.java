import java.util.regex.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;  // Added import for Stream
import java.util.Arrays;       // Added import for Arrays

public class HumanEval_91 {

    // Source Code
    static class HumanEval_91_Source {
        public static int isBored(String S) {
            String[] sentences = S.split("[.?!]\\s*");
            int count = 0;
            for (String sentence : sentences) {
                if (sentence.startsWith("I ")) {
                    count++;
                }
            }
            return count;
        }
    }

    // Transformed Code
    static class HumanEval_91_Transformed {
        public int countPersonalStatements(String text) {
            Pattern pattern = Pattern.compile("[.?!]\\s*");
            String[] segments = pattern.split(text);
            int personalStatementCount = 0;

            for (String segment : segments) {
                if (segment.startsWith("I ")) {
                    personalStatementCount++;
                }
            }

            return personalStatementCount;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {"I am bored. I think so.", 2},
        {"This is a test. I am testing.", 1},
        {"Hello world! I am here. Are you there?", 1},
        {"No personal statements here.", 0},
        {"I I I. I? I!", 5},
        {"I am fine. You are fine.", 1},
        {"I", 1},
        {"" , 0},
        {"I am alone.I think so.I am sad.", 3},
        {"I. I! I?", 3}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(testCase -> Arguments.of((String)testCase[0], (int)testCase[1]));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void isBored_vs_countPersonalStatements(String inputText, int expected) {
        assertEquals(
            HumanEval_91_Source.isBored(inputText),
            new HumanEval_91_Transformed().countPersonalStatements(inputText)
        );
        assertEquals(expected,
            HumanEval_91_Source.isBored(inputText)
        );
    }
}