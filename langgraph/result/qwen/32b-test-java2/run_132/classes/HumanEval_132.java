import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_132 {

    // Source Code
    static class SourceCode {
        public static boolean isNested(String string) {
            List<Integer> openingBracketIndex = new ArrayList<>();
            List<Integer> closingBracketIndex = new ArrayList<>();

            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == '[') {
                    openingBracketIndex.add(i);
                } else if (string.charAt(i) == ']') { // Added check for ']' to ensure only brackets are considered
                    closingBracketIndex.add(i);
                }
            }

            Collections.reverse(closingBracketIndex);
            int cnt = 0;
            int i = 0;
            int l = closingBracketIndex.size();

            for (int idx : openingBracketIndex) {
                if (i < l && idx < closingBracketIndex.get(i)) {
                    cnt++;
                    i++;
                }
            }

            return cnt >= 2;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public boolean checkForNesting(String expression) {
            List<Integer> startBracketsPositions = new ArrayList<>();
            List<Integer> endBracketsPositions = new ArrayList<>();
            int index = 0;
            while (index < expression.length()) {
                if (expression.charAt(index) == '[') {
                    startBracketsPositions.add(index);
                } else if (expression.charAt(index) == ']') { // Added check for ']' to ensure only brackets are considered
                    endBracketsPositions.add(index);
                }
                index++;
            }
            Collections.reverse(endBracketsPositions);
            int matchCount = 0;
            int j = 0;
            int totalEndBrackets = endBracketsPositions.size();
            for (int openPos : startBracketsPositions) {
                if (j < totalEndBrackets && openPos < endBracketsPositions.get(j)) {
                    matchCount++;
                    j++;
                }
            }
            return matchCount >= 2;
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "[]",
        "[[]]",
        "[][]",
        "[[[]]]",
        "[[[[[]]]]]",
        "][",
        "[]][[]",
        "[[]][][[]]",
        "[[[[[]]]]],[[[]]]",
        "[[[]]][][][[[[]]]]"
    };

    // Additional simple test inputs
    private static final String[] additionalTestCases = {
        "[",       // Single opening bracket
        "]",       // Single closing bracket
        "[[]][",   // Unbalanced brackets
        "[]]",     // Unbalanced brackets
        "",        // Empty string
        "[][][",   // Unbalanced brackets
        "a[b]c[d]",// Non-bracket characters
        "[ab[c]]",  // Nested with non-bracket characters inside
        "[abc][def]", // Two separate nested brackets
        "abc"      // No brackets at all
    };

    private static Stream<Arguments> provideTestCases() {
        return Stream.concat(
                Arrays.stream(testCases).map(Arguments::of),
                Arrays.stream(additionalTestCases).map(Arguments::of)
            );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void isNested_vs_checkForNesting(String inputString) {
        assertEquals(
            SourceCode.isNested(inputString),
            new TransformedCode().checkForNesting(inputString)
        );
    }
}