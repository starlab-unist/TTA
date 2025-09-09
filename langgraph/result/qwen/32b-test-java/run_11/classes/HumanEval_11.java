import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    @ParameterizedTest(name = "stringXor({0}, {1}) should be equal to binaryStringDifference({0}, {1})")
    @CsvSource({
        "1101, 1001",
        "1111, 0000",
        "0000, 0000",
        "101010, 010101",
        "111000, 111000",
        "110011, 001100",
        "1, 1",
        "0, 0",
        "10, 01",
        "11111111, 00000000",
        "111, 110", // Added
        "000, 111", // Added
        "101, 101", // Added
        "1100, 1010", // Added
        "111111, 111111", // Added
        "1010, 0101", // Added
        "000000, 000000", // Added
        "110011, 001100", // Added
        "111000, 111001", // Added
        "000011, 111100", // Added
        "11, 11", // Simple test case
        "00, 00", // Simple test case
        "10, 10", // Simple test case
        "01, 01", // Simple test case
        "1111, 1111", // Simple test case
        "0000, 0000" // Simple test case
    })
    void stringXor_vs_binaryStringDifference(String a, String b) {
        assertEquals(
            HumanEval_11_Source.stringXor(a, b),
            HumanEval_11_Transformed.binaryStringDifference(a, b)
        );
    }
}