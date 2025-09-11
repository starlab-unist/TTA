import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public static boolean checkForNesting(String expression) {
        List<Integer> startBracketsPositions = new ArrayList<>();
        List<Integer> endBracketsPositions = new ArrayList<>();
        int index = 0;
        while (index < expression.length()) {
            if (expression.charAt(index) == '[') {
                startBracketsPositions.add(index);
            } else {
                endBracketsPositions.add(index);
            }
            index += 1;
        }
        Collections.reverse(endBracketsPositions);
        int matchCount = 0;
        int j = 0;
        int totalEndBrackets = endBracketsPositions.size();
        for (int openPos : startBracketsPositions) {
            if (j < totalEndBrackets && openPos < endBracketsPositions.get(j)) {
                matchCount += 1;
                j += 1;
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