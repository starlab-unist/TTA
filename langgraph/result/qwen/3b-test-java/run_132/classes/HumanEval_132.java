import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_132 {

    // Source Code
    public static boolean isNested(String string) {
        int[] openingBracketIndex = new int[string.length()];
        int[] closingBracketIndex = new int[string.length()];
        int openCount = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '[') {
                openingBracketIndex[openCount++] = i;
            } else if (string.charAt(i) == ']') {
                closingBracketIndex[--openCount] = i;
            }
        }

        int cnt = 0;
        for (int idx : openingBracketIndex) {
            if (idx < closingBracketIndex[openCount - 1]) {
                cnt++;
            }
        }

        return cnt >= 2;
    }

    // Transformed Code
    public static boolean checkForNesting(String expression) {
        int[] startBracketsPositions = new int[expression.length()];
        int[] endBracketsPositions = new int[expression.length()];
        int index = 0;
        int openPos = -1;

        while (index < expression.length()) {
            if (expression.charAt(index) == '[') {
                startBracketsPositions[++openPos] = index;
            } else {
                endBracketsPositions[openPos--] = index;
            }
            index++;
        }

        int matchCount = 0;
        int j = 0;
        int totalEndBrackets = openPos + 1;

        for (int openPosValue : startBracketsPositions) {
            if (j < totalEndBrackets && openPosValue < endBracketsPositions[j]) {
                matchCount++;
                j++;
            }
        }

        return matchCount >= 2;
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

    @Test
    public void test_0() {
        assertEquals(isNested(testCases[0]), checkForNesting(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(isNested(testCases[1]), checkForNesting(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(isNested(testCases[2]), checkForNesting(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(isNested(testCases[3]), checkForNesting(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(isNested(testCases[4]), checkForNesting(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(isNested(testCases[5]), checkForNesting(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(isNested(testCases[6]), checkForNesting(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(isNested(testCases[7]), checkForNesting(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(isNested(testCases[8]), checkForNesting(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(isNested(testCases[9]), checkForNesting(testCases[9]));
    }
}