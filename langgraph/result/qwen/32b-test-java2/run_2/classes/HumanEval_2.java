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
        public static float truncateNumber(float number) {
            return number % 1.0f;
        }
    }

    // Transformed Code
    static class HumanEval_2_Transformed {
        public static double extractDecimalPart(double value) {
            double decimalPart = value - (int) value;
            return decimalPart;
        }
    }

    // Test Cases
    private static final float[] testCases = {
        3.14159f,
        0.99999f,
        123.456f,
        -789.123f,
        0.0f,
        -0.0f,
        100.0f,
        -100.0f,
        1.0f,
        -1.0f
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[0]), 
                     (float) HumanEval_2_Transformed.extractDecimalPart(testCases[0]), 0.00001);
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[1]), 
                     (float) HumanEval_2_Transformed.extractDecimalPart(testCases[1]), 0.00001);
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[2]), 
                     (float) HumanEval_2_Transformed.extractDecimalPart(testCases[2]), 0.00001);
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[3]), 
                     (float) HumanEval_2_Transformed.extractDecimalPart(testCases[3]), 0.00001);
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[4]), 
                     (float) HumanEval_2_Transformed.extractDecimalPart(testCases[4]), 0.00001);
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[5]), 
                     (float) HumanEval_2_Transformed.extractDecimalPart(testCases[5]), 0.00001);
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[6]), 
                     (float) HumanEval_2_Transformed.extractDecimalPart(testCases[6]), 0.00001);
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[7]), 
                     (float) HumanEval_2_Transformed.extractDecimalPart(testCases[7]), 0.00001);
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[8]), 
                     (float) HumanEval_2_Transformed.extractDecimalPart(testCases[8]), 0.00001);
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[9]), 
                     (float) HumanEval_2_Transformed.extractDecimalPart(testCases[9]), 0.00001);
    }
}