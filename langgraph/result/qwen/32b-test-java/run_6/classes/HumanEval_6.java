import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HumanEval_6 {
    public static List<Integer> parseNestedParens(String parenString) {
        List<Integer> result = new ArrayList<>();
        
        for (String s : parenString.split(" ")) {
            if (!s.isEmpty()) {
                result.add(parseParenGroup(s));
            }
        }
        
        return result;
    }

    private static int parseParenGroup(String s) {
        int depth = 0;
        int maxDepth = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
                maxDepth = Math.max(depth, maxDepth);
            } else {
                depth--;
            }
        }
        
        return maxDepth;
    }
}

class HumanEval_6_Transformed {
    public List<Integer> analyzeParenthesesDepth(String parenSequence) {
        List<Integer> result = new ArrayList<>();
        
        for (String segment : parenSequence.split("\\s+")) {
            if (!segment.isEmpty()) {
                result.add(calculateMaxNestingLevel(segment));
            }
        }
        
        return result;
    }

    private int calculateMaxNestingLevel(String substring) {
        int currentLevel = 0;
        int peakLevel = 0;
        
        for (char character : substring.toCharArray()) {
            if (character == '(') {
                currentLevel++;
                peakLevel = Math.max(currentLevel, peakLevel);
            } else if (character == ')') {
                currentLevel--;
            }
        }
        
        return peakLevel;
    }
}


public class HumanEval_6 {

    // Test Cases
    private static final String[] testCases = {
        "(()) ()",          // Expected: [2, 1]
        "((())) (()) ()",   // Expected: [3, 2, 1]
        "()",               // Expected: [1]
        "((( ))) (( )) ( )",// Expected: [3, 2, 1]
        "",                 // Expected: []
        "(()(()))",         // Expected: [3]
        "((()()()))",       // Expected: [3]
        "((())) () ()",     // Expected: [3, 1, 1]
        "(((())))",         // Expected: [4]
        "() () ()",         // Expected: [1, 1, 1]
        "(())(())",         // Expected: [2, 2]
        "()",               // Expected: [1]
        "",                 // Expected: []
        "(())",             // Expected: [2]
        "((()))",           // Expected: [3]
        "(",                // Expected: []
        ")",                // Expected: []
        "(()",              // Expected: []
        "())",              // Expected: []
        "( )",              // Expected: [1]
        "()()()",           // Expected: [1, 1, 1]
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_6.parseNestedParens(testCases[0]), new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[0]));
    }
    
    @Test
    public void test_1() {
        assertEquals(HumanEval_6.parseNestedParens(testCases[1]), new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[1]));
    }
    
    @Test
    public void test_2() {
        assertEquals(HumanEval_6.parseNestedParens(testCases[2]), new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[2]));
    }
    
    @Test
    public void test_3() {
        assertEquals(HumanEval_6.parseNestedParens(testCases[3]), new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[3]));
    }
    
    @Test
    public void test_4() {
        assertEquals(HumanEval_6.parseNestedParens(testCases[4]), new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[4]));
    }
    
    @Test
    public void test_5() {
        assertEquals(HumanEval_6.parseNestedParens(testCases[5]), new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[5]));
    }
    
    @Test
    public void test_6() {
        assertEquals(HumanEval_6.parseNestedParens(testCases[6]), new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[6]));
    }
    
    @Test
    public void test_7() {
        assertEquals(HumanEval_6.parseNestedParens(testCases[7]), new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[7]));
    }
    
    @Test
    public void test_8() {
        assertEquals(HumanEval_6.parseNestedParens(testCases[8]), new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[8]));
    }
    
    @Test
    public void test_9() {
        assertEquals(HumanEval_6.parseNestedParens(testCases[9]), new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[9]));
    }

    @Test
    public void test_10() {
        assertEquals(HumanEval_6.parseNestedParens(testCases[10]), new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[10]));
    }

    @Test
    public void test_11() {
        assertEquals(HumanEval_6.parseNestedParens(testCases[11]), new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[11]));
    }

    @Test
    public void test_12() {
        assertEquals(HumanEval_6.parseNestedParens(testCases[12]), new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[12]));
    }

    @Test
    public void test_13() {
        assertEquals(HumanEval_6.parseNestedParens(testCases[13]), new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[13]));
    }

    @Test
    public void test_14() {
        assertEquals(HumanEval_6.parseNestedParens(testCases[14]), new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[14]));
    }
    
    @Test
    public void test_15() { // Single opening parenthesis
        assertEquals(HumanEval_6.parseNestedParens(testCases[15]), new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[15]));
    }

    @Test
    public void test_16() { // Single closing parenthesis
        assertEquals(HumanEval_6.parseNestedParens(testCases[16]), new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[16]));
    }

    @Test
    public void test_17() { // Mismatched opening parenthesis
        assertEquals(HumanEval_6.parseNestedParens(testCases[17]), new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[17]));
    }

    @Test
    public void test_18() { // Mismatched closing parenthesis
        assertEquals(HumanEval_6.parseNestedParens(testCases[18]), new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[18]));
    }

    @Test
    public void test_19() { // Single space between parentheses
        assertEquals(HumanEval_6.parseNestedParens(testCases[19]), new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[19]));
    }

    @Test
    public void test_20() { // Multiple consecutive parentheses with no spaces
        assertEquals(HumanEval_6.parseNestedParens(testCases[20]), new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[20]));
    }
}