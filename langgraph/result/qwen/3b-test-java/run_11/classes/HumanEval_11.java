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
    static class HumanEval_11_Source {
        public static String stringXor(String a, String b) {
            return a.chars()
                    .zip(b.chars(), (x, y) -> xor(x, y))
                    .mapToObj(c -> String.valueOf(c))
                    .collect(Collectors.joining());
        }

        private static char xor(int i, int j) {
            if (i == j) {
                return '0';
            } else {
                return '1';
            }
        }
    }

    // Transformed Code
    static class HumanEval_11_Transformed {
        public static String binaryStringDifference(String str1, String str2) {
            StringBuilder result = new StringBuilder();
            int index = 0;

            while (index < str1.length()) {
                char c1 = str1.charAt(index);
                char c2 = str2.charAt(index);
                result.append(bitDiff(c1, c2));
                index++;
            }

            return result.toString();
        }

        private static char bitDiff(char c1, char c2) {
            return c1 == c2 ? '0' : '1';
        }
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
        assertEquals(HumanEval_11_Source.stringXor(testCases[0][0], testCases[0][1]), 
                     HumanEval_11_Transformed.binaryStringDifference(testCases[0][0], testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_11_Source.stringXor(testCases[1][0], testCases[1][1]), 
                     HumanEval_11_Transformed.binaryStringDifference(testCases[1][0], testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_11_Source.stringXor(testCases[2][0], testCases[2][1]), 
                     HumanEval_11_Transformed.binaryStringDifference(testCases[2][0], testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_11_Source.stringXor(testCases[3][0], testCases[3][1]), 
                     HumanEval_11_Transformed.binaryStringDifference(testCases[3][0], testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_11_Source.stringXor(testCases[4][0], testCases[4][1]), 
                     HumanEval_11_Transformed.binaryStringDifference(testCases[4][0], testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_11_Source.stringXor(testCases[5][0], testCases[5][1]), 
                     HumanEval_11_Transformed.binaryStringDifference(testCases[5][0], testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_11_Source.stringXor(testCases[6][0], testCases[6][1]), 
                     HumanEval_11_Transformed.binaryStringDifference(testCases[6][0], testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_11_Source.stringXor(testCases[7][0], testCases[7][1]), 
                     HumanEval_11_Transformed.binaryStringDifference(testCases[7][0], testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_11_Source.stringXor(testCases[8][0], testCases[8][1]), 
                     HumanEval_11_Transformed.binaryStringDifference(testCases[8][0], testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_11_Source.stringXor(testCases[9][0], testCases[9][1]), 
                     HumanEval_11_Transformed.binaryStringDifference(testCases[9][0], testCases[9][1]));
    }
}