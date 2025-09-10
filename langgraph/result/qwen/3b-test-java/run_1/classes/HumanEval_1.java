import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_1 {

    // Source Code
    static class HumanEval_1_Source {
        public static List<String> separateParenGroups(String parenString) {
            List<String> result = new ArrayList<>();
            StringBuilder currentString = new StringBuilder();
            int currentDepth = 0;

            for (char c : parenString.toCharArray()) {
                if (c == '(') {
                    currentDepth++;
                    currentString.append(c);
                } else if (c == ')') {
                    currentDepth--;
                    currentString.append(c);

                    if (currentDepth == 0) {
                        result.add(currentString.toString());
                        currentString.setLength(0);
                    }
                }
            }

            return result;
        }
    }

    // Transformed Code
    static class HumanEval_1_Transformed {
        public static List<String> extractBalancedParentheses(String inputSequence) {
            List<String> outputGroups = new ArrayList<>();
            StringBuilder tempGroup = new StringBuilder();
            int nestingLevel = 0;

            int index = 0;
            while (index < inputSequence.length()) {
                char character = inputSequence.charAt(index);
                if (character == '(') {
                    nestingLevel++;
                    tempGroup.append(character);
                } else if (character == ')') {
                    nestingLevel--;
                    tempGroup.append(character);

                    if (nestingLevel == 0) {
                        outputGroups.add(tempGroup.toString());
                        tempGroup.setLength(0); // Reset tempGroup
                    }
                }

                index++;
            }

            return outputGroups;
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "()",
        "(())",
        "((()))",
        "(()())",
        "()(())",
        "(()(()))",
        "",
        "a(b)c(d(e)f)g",
        "(abc)(def)",
        "((a)(b))(c)"
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_1_Source.separateParenGroups(testCases[0]), 
                     HumanEval_1_Transformed.extractBalancedParentheses(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_1_Source.separateParenGroups(testCases[1]), 
                     HumanEval_1_Transformed.extractBalancedParentheses(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_1_Source.separateParenGroups(testCases[2]), 
                     HumanEval_1_Transformed.extractBalancedParentheses(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_1_Source.separateParenGroups(testCases[3]), 
                     HumanEval_1_Transformed.extractBalancedParentheses(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_1_Source.separateParenGroups(testCases[4]), 
                     HumanEval_1_Transformed.extractBalancedParentheses(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_1_Source.separateParenGroups(testCases[5]), 
                     HumanEval_1_Transformed.extractBalancedParentheses(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_1_Source.separateParenGroups(testCases[6]), 
                     HumanEval_1_Transformed.extractBalancedParentheses(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_1_Source.separateParenGroups(testCases[7]), 
                     HumanEval_1_Transformed.extractBalancedParentheses(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_1_Source.separateParenGroups(testCases[8]), 
                     HumanEval_1_Transformed.extractBalancedParentheses(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_1_Source.separateParenGroups(testCases[9]), 
                     HumanEval_1_Transformed.extractBalancedParentheses(testCases[9]));
    }
}