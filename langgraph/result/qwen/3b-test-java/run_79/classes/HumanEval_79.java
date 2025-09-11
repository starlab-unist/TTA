import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_79 {

    // Source Code
    static class HumanEval_79_Source {
        public static String decimalToBinary(int decimal) {
            return "db" + Integer.toBinaryString(decimal).substring(2) + "db";
        }
    }

    // Transformed Code
    static class HumanEval_79_Transformed {
        public static String convertDecimalToBinary(int number) {
            String binaryRepresentation = Integer.toBinaryString(number);
            return "db" + binaryRepresentation + "db";
        }
    }

    // Test Cases
    private static final int[] testCases = {
        0,
        1,
        2,
        5,
        10,
        15,
        32,
        64,
        255,
        1023
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_79_Source.decimalToBinary(testCases[0]), 
                     HumanEval_79_Transformed.convertDecimalToBinary(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_79_Source.decimalToBinary(testCases[1]), 
                     HumanEval_79_Transformed.convertDecimalToBinary(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_79_Source.decimalToBinary(testCases[2]), 
                     HumanEval_79_Transformed.convertDecimalToBinary(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_79_Source.decimalToBinary(testCases[3]), 
                     HumanEval_79_Transformed.convertDecimalToBinary(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_79_Source.decimalToBinary(testCases[4]), 
                     HumanEval_79_Transformed.convertDecimalToBinary(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_79_Source.decimalToBinary(testCases[5]), 
                     HumanEval_79_Transformed.convertDecimalToBinary(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_79_Source.decimalToBinary(testCases[6]), 
                     HumanEval_79_Transformed.convertDecimalToBinary(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_79_Source.decimalToBinary(testCases[7]), 
                     HumanEval_79_Transformed.convertDecimalToBinary(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_79_Source.decimalToBinary(testCases[8]), 
                     HumanEval_79_Transformed.convertDecimalToBinary(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_79_Source.decimalToBinary(testCases[9]), 
                     HumanEval_79_Transformed.convertDecimalToBinary(testCases[9]));
    }
}