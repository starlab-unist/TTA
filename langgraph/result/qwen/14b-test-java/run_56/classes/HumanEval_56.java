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
    public static boolean correctBracketing(String brackets) {
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

    // Transformed Code
    public static boolean validateBracketSequence(String sequence) {
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
        assertEquals(correctBracketing(testCases[0]), validateBracketSequence(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(correctBracketing(testCases[1]), validateBracketSequence(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(correctBracketing(testCases[2]), validateBracketSequence(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(correctBracketing(testCases[3]), validateBracketSequence(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(correctBracketing(testCases[4]), validateBracketSequence(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(correctBracketing(testCases[5]), validateBracketSequence(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(correctBracketing(testCases[6]), validateBracketSequence(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(correctBracketing(testCases[7]), validateBracketSequence(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(correctBracketing(testCases[8]), validateBracketSequence(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(correctBracketing(testCases[9]), validateBracketSequence(testCases[9]));
    }
}