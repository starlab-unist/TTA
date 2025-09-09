import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_132 {
    // Source Code
    public static boolean isNested(String string) {
        List<Integer> openingBracketIndex = new ArrayList<>();
        List<Integer> closingBracketIndex = new ArrayList<>();
        
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '[') {
                openingBracketIndex.add(i);
            } else {
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

    // Transformed Code
    public boolean checkForNesting(String expression) {
        List<Integer> startBracketsPositions = new ArrayList<>();
        List<Integer> endBracketsPositions = new ArrayList<>();
        int index = 0;
        while (index < expression.length()) {
            if (expression.charAt(index) == '[') {
                startBracketsPositions.add(index);
            } else {
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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFunctionEquivalence {

    // Test Cases
    @ParameterizedTest
    @CsvSource({
        "[]", false,
        "[[]]", true,
        "[][]", false,
        "[[[]]]", true,
        "[[[[[]]]]]", true,
        "][", false,
        "[]][[]", false,
        "[[]][][[]]", true,
        "[[[[[]]]]],[[[]]]", true,
        "[[[]]][][][[[[]]]]", true,
        "[[[]]][]", true,
        "[[[]", false,
        "[]]", false,
        "", false,
        "[[]][", false,
        "][[]]", false,
        "[[[]]]][[[]]]", true, // Added
        "[][][][]", false,      // Added
        "[[[[[]]]]][]", true,   // Added
        "[[[]]][[[]]]", true,    // Added
        "[[[]]][", false,       // Added
        "]][[", false           // Added
    })
    @DisplayName("Test if both methods produce the same output")
    void isNested_vs_checkForNesting(String input, boolean expected) {
        assertEquals(
            HumanEval_132.isNested(input),
            new HumanEval_132().checkForNesting(input),
            "Failed for input: " + input
        );
        assertEquals(
            expected,
            HumanEval_132.isNested(input),
            "isNested failed for input: " + input
        );
        assertEquals(
            expected,
            new HumanEval_132().checkForNesting(input),
            "checkForNesting failed for input: " + input
        );
    }
}