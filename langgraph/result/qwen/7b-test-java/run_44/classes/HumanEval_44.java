import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_44 {

    // Source Code
    static class HumanEval_44_Source {
        public static String changeBase(int x, int base) {
            StringBuilder ret = new StringBuilder();
            while (x > 0) {
                ret.insert(0, x % base);
                x /= base;
            }
            return ret.toString();
        }
    }

    // Transformed Code
    static class HumanEval_44_Transformed {
        public static String convertToBase(int number, int targetBase) {
            StringBuilder result = new StringBuilder();
            while (number > 0) {
                int remainder = number % targetBase;
                result.insert(0, remainder);
                number /= targetBase;
            }
            return result.toString();
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {10, 2},   // Binary representation of 10 is 1010
        {255, 16}, // Hexadecimal representation of 255 is ff
        {100, 10}, // Decimal representation of 100 is 100
        {7, 3},    // Base 3 representation of 7 is 21
        {0, 5},    // Any base representation of 0 is 0
        {1, 2},    // Binary representation of 1 is 1
        {9, 4},    // Base 4 representation of 9 is 21
        {31, 8},   // Octal representation of 31 is 37
        {64, 2},   // Binary representation of 64 is 1000000
        {81, 9}    // Base 9 representation of 81 is 100
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_44_Source.changeBase((int) testCases[0][0], (int) testCases[0][1]), 
                     HumanEval_44_Transformed.convertToBase((int) testCases[0][0], (int) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_44_Source.changeBase((int) testCases[1][0], (int) testCases[1][1]), 
                     HumanEval_44_Transformed.convertToBase((int) testCases[1][0], (int) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_44_Source.changeBase((int) testCases[2][0], (int) testCases[2][1]), 
                     HumanEval_44_Transformed.convertToBase((int) testCases[2][0], (int) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_44_Source.changeBase((int) testCases[3][0], (int) testCases[3][1]), 
                     HumanEval_44_Transformed.convertToBase((int) testCases[3][0], (int) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_44_Source.changeBase((int) testCases[4][0], (int) testCases[4][1]), 
                     HumanEval_44_Transformed.convertToBase((int) testCases[4][0], (int) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_44_Source.changeBase((int) testCases[5][0], (int) testCases[5][1]), 
                     HumanEval_44_Transformed.convertToBase((int) testCases[5][0], (int) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_44_Source.changeBase((int) testCases[6][0], (int) testCases[6][1]), 
                     HumanEval_44_Transformed.convertToBase((int) testCases[6][0], (int) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_44_Source.changeBase((int) testCases[7][0], (int) testCases[7][1]), 
                     HumanEval_44_Transformed.convertToBase((int) testCases[7][0], (int) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_44_Source.changeBase((int) testCases[8][0], (int) testCases[8][1]), 
                     HumanEval_44_Transformed.convertToBase((int) testCases[8][0], (int) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_44_Source.changeBase((int) testCases[9][0], (int) testCases[9][1]), 
                     HumanEval_44_Transformed.convertToBase((int) testCases[9][0], (int) testCases[9][1]));
    }
}