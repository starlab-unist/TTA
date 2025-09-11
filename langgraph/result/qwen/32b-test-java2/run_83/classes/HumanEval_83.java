import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_83 {

    // Source Code
    static class HumanEval_83_Source {
        public int startsOneEnds(int n) {
            if (n == 1) return 1;
            return 18 * (int) Math.pow(10, n - 2);
        }
    }

    // Transformed Code
    static class HumanEval_83_Transformed {
        public int calculateSpecialNumber(int length) {
            if (length == 1) {
                return 1;
            }
            int multiplier = 18;
            int base = (int) Math.pow(10, length - 2);
            return multiplier * base;
        }
    }

    // Test Cases
    private static final int[] testCases = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void test_0() {
        assertEquals(new HumanEval_83_Source().startsOneEnds(testCases[0]), 
                     new HumanEval_83_Transformed().calculateSpecialNumber(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_83_Source().startsOneEnds(testCases[1]), 
                     new HumanEval_83_Transformed().calculateSpecialNumber(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_83_Source().startsOneEnds(testCases[2]), 
                     new HumanEval_83_Transformed().calculateSpecialNumber(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_83_Source().startsOneEnds(testCases[3]), 
                     new HumanEval_83_Transformed().calculateSpecialNumber(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_83_Source().startsOneEnds(testCases[4]), 
                     new HumanEval_83_Transformed().calculateSpecialNumber(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_83_Source().startsOneEnds(testCases[5]), 
                     new HumanEval_83_Transformed().calculateSpecialNumber(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_83_Source().startsOneEnds(testCases[6]), 
                     new HumanEval_83_Transformed().calculateSpecialNumber(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_83_Source().startsOneEnds(testCases[7]), 
                     new HumanEval_83_Transformed().calculateSpecialNumber(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_83_Source().startsOneEnds(testCases[8]), 
                     new HumanEval_83_Transformed().calculateSpecialNumber(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_83_Source().startsOneEnds(testCases[9]), 
                     new HumanEval_83_Transformed().calculateSpecialNumber(testCases[9]));
    }
}