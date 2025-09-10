import java.util.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_56 {

    // Source Code
    static class HumanEval_56_Source {
        public static boolean correctBracketing(String brackets) {
            int depth = 0;
            for (char b : brackets.toCharArray()) {
                if (b == '<') {
                    depth += 1;
                } else {
                    depth -= 1;
                }
                if (depth < 0) {
                    return false;
                }
            }
            return depth == 0;
        }
    }

    // Transformed Code
    static class HumanEval_56_Transformed {
        public static boolean validateBracketSequence(String sequence) {
            int level = 0;
            int index = 0;
            while (index < sequence.length()) {
                if (sequence.charAt(index) == '<') {
                    level += 1;
                } else {
                    level -= 1;
                }
                if (level < 0) {
                    return false;
                }
                index += 1;
            }
            return level == 0;
        }
    }

    // Test Cases
    private static final String[][] testCases = {
        {"<>"},
        {"<<>>"},
        {"<<<>>>"},
        {"><"},
        {"<<><>>"},
        {""},
        {"<<<<>>>>"},
        {"<<>><<>>"},
        {"<<<<><>>"},
        {"<<<<>>><"}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void correctBracketing_vs_validateBracketSequence(String inputText) {
        assertEquals(
            HumanEval_56_Source.correctBracketing(inputText),
            HumanEval_56_Transformed.validateBracketSequence(inputText)
        );
    }
}