import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_82 {

    // Source Code
    static class HumanEval_82_Source {
        public static boolean primeLength(String string) {
            int l = string.length();
            if (l == 0 || l == 1) {
                return false;
            }
            for (int i = 2; i < l; i++) {
                if (l % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    // Transformed Code
    static class HumanEval_82_Transformed {
        public static boolean checkPrimeStringLength(String inputText) {
            int stringLength = inputText.length();
            if (stringLength < 2) {
                return false;
            }
            int divisor = 2;
            while (divisor < stringLength) {
                if (stringLength % divisor == 0) {
                    return false;
                }
                divisor++;
            }
            return true;
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "",
        "a",
        "ab",
        "abc",
        "abcd",
        "abcde",
        "abcdef",
        "abcdefgh",
        "abcdefghi",
        "abcdefghij"
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_82_Source.primeLength(testCases[0]), 
                     HumanEval_82_Transformed.checkPrimeStringLength(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_82_Source.primeLength(testCases[1]), 
                     HumanEval_82_Transformed.checkPrimeStringLength(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_82_Source.primeLength(testCases[2]), 
                     HumanEval_82_Transformed.checkPrimeStringLength(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_82_Source.primeLength(testCases[3]), 
                     HumanEval_82_Transformed.checkPrimeStringLength(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_82_Source.primeLength(testCases[4]), 
                     HumanEval_82_Transformed.checkPrimeStringLength(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_82_Source.primeLength(testCases[5]), 
                     HumanEval_82_Transformed.checkPrimeStringLength(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_82_Source.primeLength(testCases[6]), 
                     HumanEval_82_Transformed.checkPrimeStringLength(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_82_Source.primeLength(testCases[7]), 
                     HumanEval_82_Transformed.checkPrimeStringLength(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_82_Source.primeLength(testCases[8]), 
                     HumanEval_82_Transformed.checkPrimeStringLength(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_82_Source.primeLength(testCases[9]), 
                     HumanEval_82_Transformed.checkPrimeStringLength(testCases[9]));
    }
}