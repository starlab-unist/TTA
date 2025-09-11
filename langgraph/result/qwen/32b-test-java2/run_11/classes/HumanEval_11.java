import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_11 {

    // Source Code
    static class HumanEval_11_Source {
        public String stringXor(String a, String b) {
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < a.length(); i++) {
                char x = a.charAt(i);
                char y = b.charAt(i);
                result.append(xor(x, y));
            }
            
            return result.toString();
        }

        private char xor(char i, char j) {
            if (i == j) {
                return '0';
            } else {
                return '1';
            }
        }
    }

    // Transformed Code
    static class HumanEval_11_Transformed {
        public String binaryStringDifference(String str1, String str2) {
            StringBuilder result = new StringBuilder();
            int index = 0;
            while (index < str1.length()) {
                result.append(bitDiff(str1.charAt(index), str2.charAt(index)));
                index++;
            }
            return result.toString();
        }

        private char bitDiff(char c1, char c2) {
            return c1 == c2 ? '0' : '1';
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
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
        assertEquals(new HumanEval_11_Source().stringXor((String) testCases[0][0], (String) testCases[0][1]), 
                     new HumanEval_11_Transformed().binaryStringDifference((String) testCases[0][0], (String) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_11_Source().stringXor((String) testCases[1][0], (String) testCases[1][1]), 
                     new HumanEval_11_Transformed().binaryStringDifference((String) testCases[1][0], (String) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_11_Source().stringXor((String) testCases[2][0], (String) testCases[2][1]), 
                     new HumanEval_11_Transformed().binaryStringDifference((String) testCases[2][0], (String) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_11_Source().stringXor((String) testCases[3][0], (String) testCases[3][1]), 
                     new HumanEval_11_Transformed().binaryStringDifference((String) testCases[3][0], (String) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_11_Source().stringXor((String) testCases[4][0], (String) testCases[4][1]), 
                     new HumanEval_11_Transformed().binaryStringDifference((String) testCases[4][0], (String) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_11_Source().stringXor((String) testCases[5][0], (String) testCases[5][1]), 
                     new HumanEval_11_Transformed().binaryStringDifference((String) testCases[5][0], (String) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_11_Source().stringXor((String) testCases[6][0], (String) testCases[6][1]), 
                     new HumanEval_11_Transformed().binaryStringDifference((String) testCases[6][0], (String) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_11_Source().stringXor((String) testCases[7][0], (String) testCases[7][1]), 
                     new HumanEval_11_Transformed().binaryStringDifference((String) testCases[7][0], (String) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_11_Source().stringXor((String) testCases[8][0], (String) testCases[8][1]), 
                     new HumanEval_11_Transformed().binaryStringDifference((String) testCases[8][0], (String) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_11_Source().stringXor((String) testCases[9][0], (String) testCases[9][1]), 
                     new HumanEval_11_Transformed().binaryStringDifference((String) testCases[9][0], (String) testCases[9][1]));
    }
}