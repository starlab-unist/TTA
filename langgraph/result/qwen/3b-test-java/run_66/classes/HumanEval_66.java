import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_66 {

    // Source Code
    public static int digitSum(String s) {
        if (s.isEmpty()) return 0;
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sum += (int) c;
            }
        }
        return sum;
    }

    // Transformed Code
    public static int calculateUppercaseAsciiSum(String inputString) {
        if (inputString == "") {
            return 0;
        }

        int total = 0;
        for (char character : inputString.toCharArray()) {
            if (Character.isUpperCase(character)) {
                total += (int) character;
            }
        }

        return total;
    }

    // Test Cases
    private static final String[] testCases = {
        "",
        "abc",
        "ABC",
        "Hello World!",
        "Python3.8",
        "OpenAI",
        "1234567890",
        "aBcDeFgHiJkLmNoPqRsTuVwXyZ",
        "MIXeD CaSe 123",
        "UPPER lower"
    };

    @Test
    public void test_0() {
        assertEquals(digitSum(testCases[0]), calculateUppercaseAsciiSum(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(digitSum(testCases[1]), calculateUppercaseAsciiSum(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(digitSum(testCases[2]), calculateUppercaseAsciiSum(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(digitSum(testCases[3]), calculateUppercaseAsciiSum(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(digitSum(testCases[4]), calculateUppercaseAsciiSum(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(digitSum(testCases[5]), calculateUppercaseAsciiSum(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(digitSum(testCases[6]), calculateUppercaseAsciiSum(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(digitSum(testCases[7]), calculateUppercaseAsciiSum(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(digitSum(testCases[8]), calculateUppercaseAsciiSum(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(digitSum(testCases[9]), calculateUppercaseAsciiSum(testCases[9]));
    }
}