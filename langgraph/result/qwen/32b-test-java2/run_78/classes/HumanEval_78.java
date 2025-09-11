import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Set;
import java.util.HashSet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_78 {

    // Source Code
    static class HumanEval_78_Source {
        public int hexKey(String num) {
            String[] primes = {"2", "3", "5", "7", "B", "D"};
            int total = 0;
            for (int i = 0; i < num.length(); i++) {
                if (contains(primes, String.valueOf(num.charAt(i)))) {
                    total += 1;
                }
            }
            return total;
        }

        private boolean contains(String[] array, String value) {
            for (String element : array) {
                if (element.equals(value)) {
                    return true;
                }
            }
            return false;
        }
    }

    // Transformed Code
    static class HumanEval_78_Transformed {
        public int countPrimeHexDigits(String hexString) {
            Set<Character> primeHexDigits = new HashSet<>(Set.of('2', '3', '5', '7', 'B', 'D'));
            int count = 0;
            int index = 0;
            while (index < hexString.length()) {
                if (primeHexDigits.contains(hexString.charAt(index))) {
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
        assertEquals(new HumanEval_78_Source().hexKey(testCases[0]), 
                     new HumanEval_78_Transformed().countPrimeHexDigits(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_78_Source().hexKey(testCases[1]), 
                     new HumanEval_78_Transformed().countPrimeHexDigits(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_78_Source().hexKey(testCases[2]), 
                     new HumanEval_78_Transformed().countPrimeHexDigits(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_78_Source().hexKey(testCases[3]), 
                     new HumanEval_78_Transformed().countPrimeHexDigits(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_78_Source().hexKey(testCases[4]), 
                     new HumanEval_78_Transformed().countPrimeHexDigits(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_78_Source().hexKey(testCases[5]), 
                     new HumanEval_78_Transformed().countPrimeHexDigits(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_78_Source().hexKey(testCases[6]), 
                     new HumanEval_78_Transformed().countPrimeHexDigits(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_78_Source().hexKey(testCases[7]), 
                     new HumanEval_78_Transformed().countPrimeHexDigits(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_78_Source().hexKey(testCases[8]), 
                     new HumanEval_78_Transformed().countPrimeHexDigits(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_78_Source().hexKey(testCases[9]), 
                     new HumanEval_78_Transformed().countPrimeHexDigits(testCases[9]));
    }
}