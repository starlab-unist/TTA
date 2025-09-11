import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_2 {

    // Source Code
    static class HumanEval_2_Source {
        public static double truncateNumber(double number) {
            return number % 1.0;
        }
    }

    // Transformed Code
    static class HumanEval_2_Transformed {
        public static float extractDecimalPart(float value) {
            float decimalPart = value - (int) value;
            return decimalPart;
        }
    }

    // Test Cases
    private static final double[] testCases = {
        3.14159,
        0.99999,
        123.456,
        -789.123,
        0.0,
        -0.0,
        100.0,
        -100.0,
        1.0,
        -1.0
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[0]), 
                     (double) HumanEval_2_Transformed.extractDecimalPart((float) testCases[0]), 1e-5);
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[1]), 
                     (double) HumanEval_2_Transformed.extractDecimalPart((float) testCases[1]), 1e-5);
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[2]), 
                     (double) HumanEval_2_Transformed.extractDecimalPart((float) testCases[2]), 1e-5);
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[3]), 
                     (double) HumanEval_2_Transformed.extractDecimalPart((float) testCases[3]), 1e-5);
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[4]), 
                     (double) HumanEval_2_Transformed.extractDecimalPart((float) testCases[4]), 1e-5);
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[5]), 
                     (double) HumanEval_2_Transformed.extractDecimalPart((float) testCases[5]), 1e-5);
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[6]), 
                     (double) HumanEval_2_Transformed.extractDecimalPart((float) testCases[6]), 1e-5);
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[7]), 
                     (double) HumanEval_2_Transformed.extractDecimalPart((float) testCases[7]), 1e-5);
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[8]), 
                     (double) HumanEval_2_Transformed.extractDecimalPart((float) testCases[8]), 1e-5);
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[9]), 
                     (double) HumanEval_2_Transformed.extractDecimalPart((float) testCases[9]), 1e-5);
    }
}