import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_78 {

    // Source Code
    public static int hexKey(String num) {
        String[] primes = {"2", "3", "5", "7", "B", "D"};
        int total = 0;
        for (int i = 0; i < num.length(); i++) {
            if (isPrime(num.charAt(i), primes)) {
                total++;
            }
        }
        return total;
    }

    private static boolean isPrime(char c, String[] primes) {
        for (String prime : primes) {
            if (prime.equals(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }

    // Transformed Code
    public static int countPrimeHexDigits(String hexString) {
        Set<Character> primeHexDigits = new HashSet<>();
        primeHexDigits.add('2');
        primeHexDigits.add('3');
        primeHexDigits.add('5');
        primeHexDigits.add('7');
        primeHexDigits.add('B');
        primeHexDigits.add('D');

        int count = 0;
        int index = 0;

        while (index < hexString.length()) {
            char currentChar = hexString.charAt(index);
            if (primeHexDigits.contains(currentChar)) {
                count++;
            }
            index++;
        }

        return count;
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
        assertEquals(hexKey(testCases[0]), countPrimeHexDigits(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(hexKey(testCases[1]), countPrimeHexDigits(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(hexKey(testCases[2]), countPrimeHexDigits(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(hexKey(testCases[3]), countPrimeHexDigits(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(hexKey(testCases[4]), countPrimeHexDigits(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(hexKey(testCases[5]), countPrimeHexDigits(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(hexKey(testCases[6]), countPrimeHexDigits(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(hexKey(testCases[7]), countPrimeHexDigits(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(hexKey(testCases[8]), countPrimeHexDigits(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(hexKey(testCases[9]), countPrimeHexDigits(testCases[9]));
    }
}