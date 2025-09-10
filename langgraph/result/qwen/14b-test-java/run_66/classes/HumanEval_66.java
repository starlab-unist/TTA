// Source Code
static class SourceCode {
    public static int digitSum(String s) {
        if (s.isEmpty()) return 0;
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sum += (int) c;
            }
        }
        return sum;
    }
}

// Transformed Code
static class TransformedCode {
    public static int calculate_uppercase_ascii_sum(String input_string) {
        if (input_string.isEmpty()) {
            return 0;
        }
        
        int total = 0;
        for (int i = 0; i < input_string.length(); i++) {
            char character = input_string.charAt(i);
            if (Character.isUpperCase(character)) {
                total += (int) character;
            }
        }
        
        return total;
    }
}

// Test Cases
import java.util.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_66 {

    private static final String[] testCases = {
        "",
        "abc",
        "ABC",
        "Hello World!",
        "Python3.8",
        "OpenAI",
        "1234567890",
        "aBcDeFgHiJkLmNoPqRsTuVwXyZ",
        "MIXeD CaSe 123",
        "UPPER lower"
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void digitSum_vs_calculate_uppercase_ascii_sum(String inputText) {
        assertEquals(
            SourceCode.digitSum(inputText),
            TransformedCode.calculate_uppercase_ascii_sum(inputText)
        );
    }
}