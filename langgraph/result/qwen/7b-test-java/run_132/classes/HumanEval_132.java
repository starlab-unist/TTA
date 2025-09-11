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
    static class HumanEval_132_Source {
        public static boolean isNested(String str) {
            ArrayList<Integer> openingBracketIndex = new ArrayList<>();
            ArrayList<Integer> closingBracketIndex = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '[') {
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
    }

    // Transformed Code
    static class HumanEval_132_Transformed {
        public boolean isNested(String expression) {
            List<Integer> openingBracketIndex = new ArrayList<>();
            List<Integer> closingBracketIndex = new ArrayList<>();
            int index = 0;
            
            while (index < expression.length()) {
                if (expression.charAt(index) == '[') {
                    openingBracketIndex.add(index);
                } else {
                    closingBracketIndex.add(index);
                }
                index++;
            }
            
            closingBracketIndex.reverse();
            
            int matchCount = 0;
            int j = 0;
            int totalEndBrackets = closingBracketIndex.size();
            
            for (int openPos : openingBracketIndex) {
                if (j < totalEndBrackets && openPos < closingBracketIndex.get(j)) {
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

    @Test
    public void test_0() {
        assertEquals(HumanEval_132_Source.isNested(testCases[0]), 
                     new HumanEval_132_Transformed().isNested(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_132_Source.isNested(testCases[1]), 
                     new HumanEval_132_Transformed().isNested(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_132_Source.isNested(testCases[2]), 
                     new HumanEval_132_Transformed().isNested(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_132_Source.isNested(testCases[3]), 
                     new HumanEval_132_Transformed().isNested(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_132_Source.isNested(testCases[4]), 
                     new HumanEval_132_Transformed().isNested(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_132_Source.isNested(testCases[5]), 
                     new HumanEval_132_Transformed().isNested(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_132_Source.isNested(testCases[6]), 
                     new HumanEval_132_Transformed().isNested(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_132_Source.isNested(testCases[7]), 
                     new HumanEval_132_Transformed().isNested(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_132_Source.isNested(testCases[8]), 
                     new HumanEval_132_Transformed().isNested(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_132_Source.isNested(testCases[9]), 
                     new HumanEval_132_Transformed().isNested(testCases[9]));
    }
}