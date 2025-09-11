import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_144 {

    // Source Code
    public static boolean simplify(String x, String n) {
        String[] partsX = x.split("/");
        String[] partsN = n.split("/");
        int a = Integer.parseInt(partsX[0]);
        int b = Integer.parseInt(partsX[1]);
        int c = Integer.parseInt(partsN[0]);
        int d = Integer.parseInt(partsN[1]);
        int numerator = a * c;
        int denom = b * d;
        return (numerator / denom == (double) numerator / denom);
    }

    // Transformed Code
    public static boolean check_fraction_simplification(String fraction1, String fraction2) {
        String[] parts1 = fraction1.split("/");
        String[] parts2 = fraction2.split("/");
        
        int num1 = Integer.parseInt(parts1[0]);
        int denom1 = Integer.parseInt(parts1[1]);
        int num2 = Integer.parseInt(parts2[0]);
        int denom2 = Integer.parseInt(parts2[1]);
        
        int result_numerator = num1 * num2;
        int result_denominator = denom1 * denom2;
        
        return result_numerator % result_denominator == 0;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {"1/2", "2/4"},    // True: (1*2) / (2*4) = 1/4
        {"3/4", "4/8"},    // True: (3*4) / (4*8) = 12/32 = 3/8
        {"5/6", "2/3"},    // False: (5*2) / (6*3) = 10/18 != int(10/18)
        {"7/9", "9/18"},   // True: (7*9) / (9*18) = 63/162 = 7/18
        {"1/1", "1/1"},    // True: (1*1) / (1*1) = 1
        {"0/1", "5/10"},   // True: (0*5) / (1*10) = 0
        {"2/3", "3/6"},    // False: (2*3) / (3*6) = 6/18 != int(6/18)
        {"10/20", "20/40"},// True: (10*20) / (20*40) = 200/800 = 1/4
        {"1/3", "3/9"},    // True: (1*3) / (3*9) = 3/27 = 1/9
        {"5/7", "7/14"}    // False: (5*7) / (7*14) = 35/98 != int(35/98)
    };

    @Test
    public void test_0() {
        assertEquals(simplify((String) testCases[0][0], (String) testCases[0][1]), 
                     check_fraction_simplification((String) testCases[0][0], (String) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(simplify((String) testCases[1][0], (String) testCases[1][1]), 
                     check_fraction_simplification((String) testCases[1][0], (String) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(simplify((String) testCases[2][0], (String) testCases[2][1]), 
                     check_fraction_simplification((String) testCases[2][0], (String) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(simplify((String) testCases[3][0], (String) testCases[3][1]), 
                     check_fraction_simplification((String) testCases[3][0], (String) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(simplify((String) testCases[4][0], (String) testCases[4][1]), 
                     check_fraction_simplification((String) testCases[4][0], (String) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(simplify((String) testCases[5][0], (String) testCases[5][1]), 
                     check_fraction_simplification((String) testCases[5][0], (String) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(simplify((String) testCases[6][0], (String) testCases[6][1]), 
                     check_fraction_simplification((String) testCases[6][0], (String) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(simplify((String) testCases[7][0], (String) testCases[7][1]), 
                     check_fraction_simplification((String) testCases[7][0], (String) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(simplify((String) testCases[8][0], (String) testCases[8][1]), 
                     check_fraction_simplification((String) testCases[8][0], (String) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(simplify((String) testCases[9][0], (String) testCases[9][1]), 
                     check_fraction_simplification((String) testCases[9][0], (String) testCases[9][1]));
    }
}