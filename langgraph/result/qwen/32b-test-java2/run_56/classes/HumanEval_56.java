import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_56 {

    // Source Code
    static class HumanEval_56_Source {
        public boolean correctBracketing(String brackets) {
            int depth = 0;
            for (char b : brackets.toCharArray()) {
                if (b == '<') {
                    depth += 1;
                } else {
                    depth -= 1;
                }
                if (depth < 0) {
                    return false;
                }
            }
            return depth == 0;
        }
    }

    // Transformed Code
    static class HumanEval_56_Transformed {
        public boolean validateBracketSequence(String sequence) {
            int level = 0;
            int index = 0;
            while (index < sequence.length()) {
                if (sequence.charAt(index) == '<') {
                    level += 1;
                } else {
                    level -= 1;
                }
                if (level < 0) {
                    return false;
                }
                index += 1;
            }
            return level == 0;
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "<>",
        "<<>>",
        "<<<>>>",
        "><",
        "<<><>>",
        "",
        "<<<<>>>>",
        "<<>><<>>",
        "<<<<><>>",
        "<<<<>>><"
    };

    @Test
    public void test_0() {
        assertEquals(new HumanEval_56_Source().correctBracketing(testCases[0]), 
                     new HumanEval_56_Transformed().validateBracketSequence(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_56_Source().correctBracketing(testCases[1]), 
                     new HumanEval_56_Transformed().validateBracketSequence(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_56_Source().correctBracketing(testCases[2]), 
                     new HumanEval_56_Transformed().validateBracketSequence(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_56_Source().correctBracketing(testCases[3]), 
                     new HumanEval_56_Transformed().validateBracketSequence(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_56_Source().correctBracketing(testCases[4]), 
                     new HumanEval_56_Transformed().validateBracketSequence(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_56_Source().correctBracketing(testCases[5]), 
                     new HumanEval_56_Transformed().validateBracketSequence(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_56_Source().correctBracketing(testCases[6]), 
                     new HumanEval_56_Transformed().validateBracketSequence(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_56_Source().correctBracketing(testCases[7]), 
                     new HumanEval_56_Transformed().validateBracketSequence(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_56_Source().correctBracketing(testCases[8]), 
                     new HumanEval_56_Transformed().validateBracketSequence(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_56_Source().correctBracketing(testCases[9]), 
                     new HumanEval_56_Transformed().validateBracketSequence(testCases[9]));
    }
}