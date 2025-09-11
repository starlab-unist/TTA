import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_76 {

    // Source Code
    static class HumanEval_76_Source {
        public boolean isSimplePower(int x, int n) {
            if (n == 1) {
                return x == 1;
            }
            int power = 1;
            while (power < x) {
                power *= n;
            }
            return power == x;
        }
    }

    // Transformed Code
    static class HumanEval_76_Transformed {
        public boolean checkPowerRelation(int base, int exponent) {
            if (exponent == 1) {
                return base == 1;
            }
            
            int currentValue = 1;
            while (currentValue < base) {
                currentValue *= exponent;
            }
            
            return currentValue == base;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {1, 1},     // True: 1^1 = 1
        {8, 2},     // False: No power of 2 equals 8 exactly within the loop
        {9, 3},     // True: 3^2 = 9
        {27, 3},    // True: 3^3 = 27
        {16, 4},    // True: 4^2 = 16
        {10, 10},   // True: 10^1 = 10
        {256, 2},   // True: 2^8 = 256
        {1, 5},     // False: 5^0 = 1, but loop condition fails for x > 1 when n > 1
        {0, 2},     // False: No power of 2 equals 0
        {7, 3}      // False: No power of 3 equals 7 exactly within the loop
    };

    @Test
    public void test_0() {
        assertEquals(new HumanEval_76_Source().isSimplePower((int) testCases[0][0], (int) testCases[0][1]), 
                     new HumanEval_76_Transformed().checkPowerRelation((int) testCases[0][0], (int) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_76_Source().isSimplePower((int) testCases[1][0], (int) testCases[1][1]), 
                     new HumanEval_76_Transformed().checkPowerRelation((int) testCases[1][0], (int) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_76_Source().isSimplePower((int) testCases[2][0], (int) testCases[2][1]), 
                     new HumanEval_76_Transformed().checkPowerRelation((int) testCases[2][0], (int) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_76_Source().isSimplePower((int) testCases[3][0], (int) testCases[3][1]), 
                     new HumanEval_76_Transformed().checkPowerRelation((int) testCases[3][0], (int) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_76_Source().isSimplePower((int) testCases[4][0], (int) testCases[4][1]), 
                     new HumanEval_76_Transformed().checkPowerRelation((int) testCases[4][0], (int) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_76_Source().isSimplePower((int) testCases[5][0], (int) testCases[5][1]), 
                     new HumanEval_76_Transformed().checkPowerRelation((int) testCases[5][0], (int) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_76_Source().isSimplePower((int) testCases[6][0], (int) testCases[6][1]), 
                     new HumanEval_76_Transformed().checkPowerRelation((int) testCases[6][0], (int) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_76_Source().isSimplePower((int) testCases[7][0], (int) testCases[7][1]), 
                     new HumanEval_76_Transformed().checkPowerRelation((int) testCases[7][0], (int) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_76_Source().isSimplePower((int) testCases[8][0], (int) testCases[8][1]), 
                     new HumanEval_76_Transformed().checkPowerRelation((int) testCases[8][0], (int) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_76_Source().isSimplePower((int) testCases[9][0], (int) testCases[9][1]), 
                     new HumanEval_76_Transformed().checkPowerRelation((int) testCases[9][0], (int) testCases[9][1]));
    }
}