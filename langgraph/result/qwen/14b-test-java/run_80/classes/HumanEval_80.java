import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_80 {

    // Source Code
    static class SourceCode {
        public static boolean isHappy(String s) {
            if (s.length() < 3) {
                return false;
            }

            for (int i = 0; i < s.length() - 2; i++) {
                if (s.charAt(i) == s.charAt(i + 1) || s.charAt(i + 1) == s.charAt(i + 2) || s.charAt(i) == s.charAt(i + 2)) {
                    return false;
                }
            }
            return true;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static boolean check_happiness(int[] sequence) {
            if (sequence.length < 3) {
                return false;
            }

            int index = 0;
            while (index < sequence.length - 2) {
                if (sequence[index] == sequence[index + 1] ||
                    sequence[index + 1] == sequence[index + 2] ||
                    sequence[index] == sequence[index + 2]) {
                    return false;
                }
                index += 1;
            }

            return true;
        }
    }

    // Test Cases
    private static final String[][] stringTestCases = {
        {"abc"},       // happy
        {"aabbcc"},    // not happy
        {"abac"},      // happy
        {"aaa"},       // not happy
        {"abcdefg"},   // happy
        {"a"},         // not happy (less than 3 characters)
        {"ab"},        // not happy (less than 3 characters)
        {"aab"},       // not happy
        {"abcabc"},    // happy
        {"aabbba"}     // not happy
    };

    private static List<Arguments> provideTestCases() {
        List<Arguments> cases = new ArrayList<>();
        for (String[] testCase : stringTestCases) {
            String inputString = testCase[0];
            int[] inputArray = inputString.chars().toArray();
            boolean expected = SourceCode.isHappy(inputString);
            cases.add(Arguments.of(inputString, inputArray, expected));
        }
        return cases;
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void isHappy_vs_check_happiness(String inputString, int[] inputArray, boolean expected) {
        assertEquals(
            SourceCode.isHappy(inputString),
            TransformedCode.check_happiness(inputArray)
        );
    }
}