import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_48 {

    // Source Code
    public static boolean isPalindrome(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // Transformed Code
    public static boolean check_palindrome(String sequence) {
        int index = 0;
        int length = sequence.length();
        
        while (index < length / 2) {
            if (sequence.charAt(index) != sequence.charAt(length - index - 1)) {
                return false;
            }
            index += 1;
        }
        return true;
    }

    // Test Cases
    private static final String[] testCases = {
        "racecar",
        "level",
        "hello",
        "world",
        "",
        "a",
        "abba",
        "abcba",
        "noon",
        "python"
    };

    @Test
    public void test_0() {
        assertEquals(isPalindrome(testCases[0]), check_palindrome(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(isPalindrome(testCases[1]), check_palindrome(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(isPalindrome(testCases[2]), check_palindrome(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(isPalindrome(testCases[3]), check_palindrome(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(isPalindrome(testCases[4]), check_palindrome(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(isPalindrome(testCases[5]), check_palindrome(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(isPalindrome(testCases[6]), check_palindrome(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(isPalindrome(testCases[7]), check_palindrome(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(isPalindrome(testCases[8]), check_palindrome(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(isPalindrome(testCases[9]), check_palindrome(testCases[9]));
    }
}