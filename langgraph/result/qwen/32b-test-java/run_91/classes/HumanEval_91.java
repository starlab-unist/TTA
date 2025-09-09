import java.util.regex.*;
import java.util.stream.Stream;
import java.util.Arrays;

class HumanEval_91 {
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

class TransformedCode {
    public static int countPersonalStatements(String text) {
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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_91 {

    // Test Cases
    private static final String[] testCases = {
        "I am bored. I think so.",
        "This is a test. I am testing.",
        "Hello world! I am here. Are you there?",
        "No personal statements here.",
        "I I I. I? I!",
        "I am fine. You are fine.",
        "I",
        "",
        "I am alone.I think so.I am sad.",
        "I. I! I?",
        "Why not? I will do it.",
        "Multiple... punctuation!!! marks...",
        "Trailing space. ",
        "No leading 'I'. This is a test.",
        "Mixed case: i am here. I am there."
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void isBored_vs_countPersonalStatements(String inputText) {
        assertEquals(
            HumanEval_91.isBored(inputText),
            TransformedCode.countPersonalStatements(inputText)
        );
    }
}