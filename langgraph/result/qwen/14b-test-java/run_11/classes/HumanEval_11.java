import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_11 {

    // Source Code
    public static String stringXor(String a, String b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            char x = a.charAt(i);
            char y = b.charAt(i);
            if (x == y) {
                result.append('0');
            } else {
                result.append('1');
            }
        }
        return result.toString();
    }

    // Transformed Code
    public static String binaryStringDifference(String str1, String str2) {
        return bitDiff(str1, str2);
    }

    private static String bitDiff(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < str1.length()) {
            result.append(str1.charAt(index) == str2.charAt(index) ? '0' : '1');
            index++;
        }
        return result.toString();
    }

    // Test Cases
    private static final String[][] testCases = {
        {"1101", "1001"},
        {"1111", "0000"},
        {"0000", "0000"},
        {"101010", "010101"},
        {"111000", "111000"},
        {"110011", "001100"},
        {"1", "1"},
        {"0", "0"},
        {"10", "01"},
        {"11111111", "00000000"}
    };

    @Test
    public void test_0() {
        assertEquals(stringXor(testCases[0][0], testCases[0][1]), binaryStringDifference(testCases[0][0], testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(stringXor(testCases[1][0], testCases[1][1]), binaryStringDifference(testCases[1][0], testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(stringXor(testCases[2][0], testCases[2][1]), binaryStringDifference(testCases[2][0], testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(stringXor(testCases[3][0], testCases[3][1]), binaryStringDifference(testCases[3][0], testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(stringXor(testCases[4][0], testCases[4][1]), binaryStringDifference(testCases[4][0], testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(stringXor(testCases[5][0], testCases[5][1]), binaryStringDifference(testCases[5][0], testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(stringXor(testCases[6][0], testCases[6][1]), binaryStringDifference(testCases[6][0], testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(stringXor(testCases[7][0], testCases[7][1]), binaryStringDifference(testCases[7][0], testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(stringXor(testCases[8][0], testCases[8][1]), binaryStringDifference(testCases[8][0], testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(stringXor(testCases[9][0], testCases[9][1]), binaryStringDifference(testCases[9][0], testCases[9][1]));
    }
}