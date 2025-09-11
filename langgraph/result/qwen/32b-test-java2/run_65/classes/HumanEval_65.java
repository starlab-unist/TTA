import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_65 {

    // Source Code
    static class HumanEval_65_Source {
        public static String circularShift(int x, int shift) {
            String s = Integer.toString(x);
            if (shift > s.length()) {
                return new StringBuilder(s).reverse().toString();
            } else {
                return s.substring(s.length() - shift) + s.substring(0, s.length() - shift);
            }
        }
    }

    // Transformed Code
    static class HumanEval_65_Transformed {
        public String rotateString(int number, int offset) {
            String numStr = Integer.toString(number);
            int length = numStr.length();
            
            if (offset >= length) {
                return new StringBuilder(numStr).reverse().toString();
            } else {
                int splitPoint = length - offset;
                String rotatedPart = numStr.substring(splitPoint);
                String remainingPart = numStr.substring(0, splitPoint);
                return rotatedPart + remainingPart;
            }
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {12345, 2},       // Normal circular shift
        {12345, 5},       // Full rotation, should return the same number
        {12345, 6},       // Shift greater than length, should reverse
        {987654321, 3},   // Normal circular shift with a larger number
        {987654321, 9},   // Full rotation, should return the same number
        {987654321, 10},  // Shift greater than length, should reverse
        {11111, 2},       // All digits same, shift within bounds
        {11111, 6},       // All digits same, shift out of bounds
        {0, 1},           // Single digit number, shift within bounds
        {0, 0},           // Single digit number, no shift
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_65_Source.circularShift((int) testCases[0][0], (int) testCases[0][1]), 
                     new HumanEval_65_Transformed().rotateString((int) testCases[0][0], (int) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_65_Source.circularShift((int) testCases[1][0], (int) testCases[1][1]), 
                     new HumanEval_65_Transformed().rotateString((int) testCases[1][0], (int) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_65_Source.circularShift((int) testCases[2][0], (int) testCases[2][1]), 
                     new HumanEval_65_Transformed().rotateString((int) testCases[2][0], (int) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_65_Source.circularShift((int) testCases[3][0], (int) testCases[3][1]), 
                     new HumanEval_65_Transformed().rotateString((int) testCases[3][0], (int) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_65_Source.circularShift((int) testCases[4][0], (int) testCases[4][1]), 
                     new HumanEval_65_Transformed().rotateString((int) testCases[4][0], (int) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_65_Source.circularShift((int) testCases[5][0], (int) testCases[5][1]), 
                     new HumanEval_65_Transformed().rotateString((int) testCases[5][0], (int) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_65_Source.circularShift((int) testCases[6][0], (int) testCases[6][1]), 
                     new HumanEval_65_Transformed().rotateString((int) testCases[6][0], (int) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_65_Source.circularShift((int) testCases[7][0], (int) testCases[7][1]), 
                     new HumanEval_65_Transformed().rotateString((int) testCases[7][0], (int) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_65_Source.circularShift((int) testCases[8][0], (int) testCases[8][1]), 
                     new HumanEval_65_Transformed().rotateString((int) testCases[8][0], (int) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_65_Source.circularShift((int) testCases[9][0], (int) testCases[9][1]), 
                     new HumanEval_65_Transformed().rotateString((int) testCases[9][0], (int) testCases[9][1]));
    }
}