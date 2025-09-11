import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_15 {

    // Source Code
    static class HumanEval_15_Source {
        public static String stringSequence(int n) {
            StringBuilder result = new StringBuilder();
            for (int x = 0; x <= n; x++) {
                if (x > 0) {
                    result.append(" ");
                }
                result.append(x);
            }
            return result.toString();
        }
    }

    // Transformed Code
    static class HumanEval_15_Transformed {
        public static String stringSequence(int n) {
            StringBuilder numberList = new StringBuilder();
            int index = 0;

            while (index <= n) {
                if (index > 0) {
                    numberList.append(" ");
                }
                numberList.append(index);
                index++;
            }

            return numberList.toString();
        }
    }

    // Test Cases
    private static final int[] testCases = {
        0,
        1,
        5,
        10,
        20,
        100,
        -1,  // Edge case: negative input
        3,
        7,
        15
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_15_Source.stringSequence(testCases[0]), HumanEval_15_Transformed.stringSequence(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_15_Source.stringSequence(testCases[1]), HumanEval_15_Transformed.stringSequence(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_15_Source.stringSequence(testCases[2]), HumanEval_15_Transformed.stringSequence(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_15_Source.stringSequence(testCases[3]), HumanEval_15_Transformed.stringSequence(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_15_Source.stringSequence(testCases[4]), HumanEval_15_Transformed.stringSequence(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_15_Source.stringSequence(testCases[5]), HumanEval_15_Transformed.stringSequence(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_15_Source.stringSequence(testCases[6]), HumanEval_15_Transformed.stringSequence(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_15_Source.stringSequence(testCases[7]), HumanEval_15_Transformed.stringSequence(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_15_Source.stringSequence(testCases[8]), HumanEval_15_Transformed.stringSequence(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_15_Source.stringSequence(testCases[9]), HumanEval_15_Transformed.stringSequence(testCases[9]));
    }
}