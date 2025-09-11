import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_84 {

    // Source Code
    static class HumanEval_84_Source {
        public static String solve(int N) {
            int sum = 0;
            String numStr = Integer.toString(N);
            for (char c : numStr.toCharArray()) {
                sum += Character.getNumericValue(c);
            }
            return Integer.toBinaryString(sum).substring(2);
        }
    }

    // Transformed Code
    static class HumanEval_84_Transformed {
        public static String convertToBinaryString(int number) {
            int digitSum = 0;
            String numberStr = Integer.toString(number);
            
            for (char digit : numberStr.toCharArray()) {
                digitSum += Character.getNumericValue(digit);
            }
            
            String binaryRepresentation = Integer.toBinaryString(digitSum);
            return binaryRepresentation;
        }
    }

    // Test Cases
    private static final int[] testCases = {
        0,
        1,
        9,
        123,
        456,
        789,
        1001,
        11111111,
        987654321,
        (int) Math.pow(2, 10)
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_84_Source.solve(testCases[0]), HumanEval_84_Transformed.convertToBinaryString(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_84_Source.solve(testCases[1]), HumanEval_84_Transformed.convertToBinaryString(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_84_Source.solve(testCases[2]), HumanEval_84_Transformed.convertToBinaryString(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_84_Source.solve(testCases[3]), HumanEval_84_Transformed.convertToBinaryString(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_84_Source.solve(testCases[4]), HumanEval_84_Transformed.convertToBinaryString(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_84_Source.solve(testCases[5]), HumanEval_84_Transformed.convertToBinaryString(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_84_Source.solve(testCases[6]), HumanEval_84_Transformed.convertToBinaryString(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_84_Source.solve(testCases[7]), HumanEval_84_Transformed.convertToBinaryString(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_84_Source.solve(testCases[8]), HumanEval_84_Transformed.convertToBinaryString(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_84_Source.solve(testCases[9]), HumanEval_84_Transformed.convertToBinaryString(testCases[9]));
    }
}