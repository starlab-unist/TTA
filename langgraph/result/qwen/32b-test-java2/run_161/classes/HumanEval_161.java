import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;  // Add this import statement
import java.util.Arrays;      // Add this import statement

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_161 {

    // Source Code
    static class SourceCode {
        public String solve(String s) {
            int flg = 0;
            int idx = 0;
            char[] newStr = s.toCharArray();
            for (char i : s.toCharArray()) {
                if (Character.isLetter(i)) {
                    newStr[idx] = Character.isUpperCase(i) ? Character.toLowerCase(i) : Character.toUpperCase(i);
                    flg = 1;
                }
                idx++;
            }
            StringBuilder result = new StringBuilder(new String(newStr));
            if (flg == 0) {
                return result.reverse().toString();
            }
            return result.toString();
        }
    }

    // Transformed Code
    static class TransformedCode {
        public String transformString(String inputString) {
            boolean modified = false;
            int position = 0;
            char[] resultChars = inputString.toCharArray();
            for (char c : inputString.toCharArray()) {
                if (Character.isLetter(c)) {
                    resultChars[position] = Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
                    modified = true;
                }
                position++;
            }
            String transformedString = new String(resultChars);
            if (!modified) {
                return new StringBuilder(transformedString).reverse().toString();
            }
            return transformedString;
        }
    }

    // Test Cases
    private static final String[][] testCases = {
        {"Hello World"},
        {"Python3.8"},
        {"1234567890"},
        {"!@#$%^&*()"},
        {"aBcDeFgHiJ"},
        {"ABCdef123"},
        {"No Change 123"},
        {"SWAPcase"},
        {""},
        {" "},
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void solve_vs_transformString(String inputText) {
        assertEquals(
            new SourceCode().solve(inputText),  // Call the method on an instance of SourceCode
            new TransformedCode().transformString(inputText)  // Call the method on an instance of TransformedCode
        );
    }
}