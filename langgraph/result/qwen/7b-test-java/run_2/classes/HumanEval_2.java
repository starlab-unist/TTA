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
        public static double extractDecimalPart(double value) {
            double decimalPart = value - Math.floor(value);
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
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[0]), HumanEval_2_Transformed.extractDecimalPart(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[1]), HumanEval_2_Transformed.extractDecimalPart(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[2]), HumanEval_2_Transformed.extractDecimalPart(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[3]), HumanEval_2_Transformed.extractDecimalPart(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[4]), HumanEval_2_Transformed.extractDecimalPart(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[5]), HumanEval_2_Transformed.extractDecimalPart(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[6]), HumanEval_2_Transformed.extractDecimalPart(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[7]), HumanEval_2_Transformed.extractDecimalPart(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[8]), HumanEval_2_Transformed.extractDecimalPart(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_2_Source.truncateNumber(testCases[9]), HumanEval_2_Transformed.extractDecimalPart(testCases[9]));
    }
}