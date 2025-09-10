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
        public double extractDecimalPart(double value) {
            double decimalPart = value - (int) value;
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
        assertEquals(HumanEval_2_Source.truncateNumber((float) testCases[0]), 
                     new HumanEval_2_Transformed().extractDecimalPart(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_2_Source.truncateNumber((float) testCases[1]), 
                     new HumanEval_2_Transformed().extractDecimalPart(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_2_Source.truncateNumber((float) testCases[2]), 
                     new HumanEval_2_Transformed().extractDecimalPart(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_2_Source.truncateNumber((float) testCases[3]), 
                     new HumanEval_2_Transformed().extractDecimalPart(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_2_Source.truncateNumber((float) testCases[4]), 
                     new HumanEval_2_Transformed().extractDecimalPart(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_2_Source.truncateNumber((float) testCases[5]), 
                     new HumanEval_2_Transformed().extractDecimalPart(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_2_Source.truncateNumber((float) testCases[6]), 
                     new HumanEval_2_Transformed().extractDecimalPart(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_2_Source.truncateNumber((float) testCases[7]), 
                     new HumanEval_2_Transformed().extractDecimalPart(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_2_Source.truncateNumber((float) testCases[8]), 
                     new HumanEval_2_Transformed().extractDecimalPart(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_2_Source.truncateNumber((float) testCases[9]), 
                     new HumanEval_2_Transformed().extractDecimalPart(testCases[9]));
    }
}