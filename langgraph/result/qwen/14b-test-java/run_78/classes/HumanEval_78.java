import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_78 {

    // Source Code
    static class HumanEval_78_Source {
        public static int hexKey(String num) {
            String[] primes = {"2", "3", "5", "7", "B", "D"};
            int total = 0;
            for (int i = 0; i < num.length(); i++) {
                for (String prime : primes) {
                    if (Character.toString(num.charAt(i)).equals(prime)) {
                        total += 1;
                        break;
                    }
                }
            }
            return total;
        }
    }

    // Transformed Code
    static class HumanEval_78_Transformed {
        public static int countPrimeHexDigits(String hexString) {
            String primeHexDigits = "2357BD";
            int count = 0;
            int index = 0;
            while (index < hexString.length()) {
                if (primeHexDigits.indexOf(hexString.charAt(index)) != -1) {
                    count += 1;
                }
                index += 1;
            }
            return count;
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "23456789ABCDEF",
        "FFFFFFFF",
        "1234567890",
        "BDBDBD",
        "222222",
        "777777",
        "",
        "AEC",
        "BEEF",
        "DEADBEEF"
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_78_Source.hexKey(testCases[0]), HumanEval_78_Transformed.countPrimeHexDigits(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_78_Source.hexKey(testCases[1]), HumanEval_78_Transformed.countPrimeHexDigits(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_78_Source.hexKey(testCases[2]), HumanEval_78_Transformed.countPrimeHexDigits(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_78_Source.hexKey(testCases[3]), HumanEval_78_Transformed.countPrimeHexDigits(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_78_Source.hexKey(testCases[4]), HumanEval_78_Transformed.countPrimeHexDigits(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_78_Source.hexKey(testCases[5]), HumanEval_78_Transformed.countPrimeHexDigits(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_78_Source.hexKey(testCases[6]), HumanEval_78_Transformed.countPrimeHexDigits(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_78_Source.hexKey(testCases[7]), HumanEval_78_Transformed.countPrimeHexDigits(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_78_Source.hexKey(testCases[8]), HumanEval_78_Transformed.countPrimeHexDigits(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_78_Source.hexKey(testCases[9]), HumanEval_78_Transformed.countPrimeHexDigits(testCases[9]));
    }
}