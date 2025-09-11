import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_49 {

    // Source Code
    static class HumanEval_49_Source {
        public static int modp(int n, int p) {
            int ret = 1;
            for (int i = 0; i < n; i++) {
                ret = (2 * ret) % p;
            }
            return ret;
        }
    }

    // Transformed Code
    static class HumanEval_49_Transformed {
        public static int calculateModularExponentiation(int baseCount, int modulus) {
            int result = 1;
            int index = 0;
            while (index < baseCount) {
                result = (2 * result) % modulus;
                index += 1;
            }
            return result;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {0, 5},       // n=0, p=5
        {1, 3},       // n=1, p=3
        {2, 7},       // n=2, p=7
        {3, 4},       // n=3, p=4
        {5, 10},      // n=5, p=10
        {10, 13},     // n=10, p=13
        {20, 17},     // n=20, p=17
        {31, 31},     // n=31, p=31
        {50, 61},     // n=50, p=61
        {100, 97}     // n=100, p=97
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_49_Source.modp((int) testCases[0][0], (int) testCases[0][1]), 
                     HumanEval_49_Transformed.calculateModularExponentiation((int) testCases[0][0], (int) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_49_Source.modp((int) testCases[1][0], (int) testCases[1][1]), 
                     HumanEval_49_Transformed.calculateModularExponentiation((int) testCases[1][0], (int) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_49_Source.modp((int) testCases[2][0], (int) testCases[2][1]), 
                     HumanEval_49_Transformed.calculateModularExponentiation((int) testCases[2][0], (int) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_49_Source.modp((int) testCases[3][0], (int) testCases[3][1]), 
                     HumanEval_49_Transformed.calculateModularExponentiation((int) testCases[3][0], (int) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_49_Source.modp((int) testCases[4][0], (int) testCases[4][1]), 
                     HumanEval_49_Transformed.calculateModularExponentiation((int) testCases[4][0], (int) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_49_Source.modp((int) testCases[5][0], (int) testCases[5][1]), 
                     HumanEval_49_Transformed.calculateModularExponentiation((int) testCases[5][0], (int) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_49_Source.modp((int) testCases[6][0], (int) testCases[6][1]), 
                     HumanEval_49_Transformed.calculateModularExponentiation((int) testCases[6][0], (int) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_49_Source.modp((int) testCases[7][0], (int) testCases[7][1]), 
                     HumanEval_49_Transformed.calculateModularExponentiation((int) testCases[7][0], (int) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_49_Source.modp((int) testCases[8][0], (int) testCases[8][1]), 
                     HumanEval_49_Transformed.calculateModularExponentiation((int) testCases[8][0], (int) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_49_Source.modp((int) testCases[9][0], (int) testCases[9][1]), 
                     HumanEval_49_Transformed.calculateModularExponentiation((int) testCases[9][0], (int) testCases[9][1]));
    }
}