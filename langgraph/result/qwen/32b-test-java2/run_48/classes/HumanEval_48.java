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
    static class HumanEval_48_Source {
        public boolean isPalindrome(String text) {
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }

    // Transformed Code
    static class HumanEval_48_Transformed {
        public boolean checkPalindrome(String sequence) {
            int index = 0;
            int length = sequence.length();
            
            while (index < length / 2) {
                if (sequence.charAt(index) != sequence.charAt(length - index - 1)) {
                    return false;
                }
                index++;
            }
            return true;
        }
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
        assertEquals(new HumanEval_48_Source().isPalindrome(testCases[0]), 
                     new HumanEval_48_Transformed().checkPalindrome(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_48_Source().isPalindrome(testCases[1]), 
                     new HumanEval_48_Transformed().checkPalindrome(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_48_Source().isPalindrome(testCases[2]), 
                     new HumanEval_48_Transformed().checkPalindrome(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_48_Source().isPalindrome(testCases[3]), 
                     new HumanEval_48_Transformed().checkPalindrome(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_48_Source().isPalindrome(testCases[4]), 
                     new HumanEval_48_Transformed().checkPalindrome(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_48_Source().isPalindrome(testCases[5]), 
                     new HumanEval_48_Transformed().checkPalindrome(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_48_Source().isPalindrome(testCases[6]), 
                     new HumanEval_48_Transformed().checkPalindrome(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_48_Source().isPalindrome(testCases[7]), 
                     new HumanEval_48_Transformed().checkPalindrome(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_48_Source().isPalindrome(testCases[8]), 
                     new HumanEval_48_Transformed().checkPalindrome(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_48_Source().isPalindrome(testCases[9]), 
                     new HumanEval_48_Transformed().checkPalindrome(testCases[9]));
    }
}