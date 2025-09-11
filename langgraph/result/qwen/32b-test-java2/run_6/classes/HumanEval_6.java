import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_6 {

    // Source Code
    static class HumanEval_6_Source {
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

    // Transformed Code
    static class HumanEval_6_Transformed {
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

    // Test Cases
    private static final String[] testCases = {
        "(()) ()",
        "((())) (()) ()",
        "()",
        "((( ))) (( )) ( )",
        "",
        "(()(()))",
        "((()()()))",
        "((())) () ()",
        "(((())))",
        "() () ()"
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_6_Source.parseNestedParens(testCases[0]), 
                     new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_6_Source.parseNestedParens(testCases[1]), 
                     new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_6_Source.parseNestedParens(testCases[2]), 
                     new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_6_Source.parseNestedParens(testCases[3]), 
                     new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_6_Source.parseNestedParens(testCases[4]), 
                     new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_6_Source.parseNestedParens(testCases[5]), 
                     new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_6_Source.parseNestedParens(testCases[6]), 
                     new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_6_Source.parseNestedParens(testCases[7]), 
                     new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_6_Source.parseNestedParens(testCases[8]), 
                     new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_6_Source.parseNestedParens(testCases[9]), 
                     new HumanEval_6_Transformed().analyzeParenthesesDepth(testCases[9]));
    }
}