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
    static class HumanEval_66_Source {
        public static int digitSum(String s) {
            if (s.isEmpty()) return 0;
            return s.chars()
                     .filter(Character::isUpperCase)
                     .mapToObj(c -> (char) c)
                     .mapToInt(c -> (int) c)
                     .sum();
        }
    }

    // Transformed Code
    static class HumanEval_66_Transformed {
        public static int calculateUppercaseAsciiSum(String inputString) {
            if (inputString.isEmpty()) {
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
        assertEquals(HumanEval_66_Source.digitSum(testCases[0]), 
                     HumanEval_66_Transformed.calculateUppercaseAsciiSum(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_66_Source.digitSum(testCases[1]), 
                     HumanEval_66_Transformed.calculateUppercaseAsciiSum(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_66_Source.digitSum(testCases[2]), 
                     HumanEval_66_Transformed.calculateUppercaseAsciiSum(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_66_Source.digitSum(testCases[3]), 
                     HumanEval_66_Transformed.calculateUppercaseAsciiSum(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_66_Source.digitSum(testCases[4]), 
                     HumanEval_66_Transformed.calculateUppercaseAsciiSum(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_66_Source.digitSum(testCases[5]), 
                     HumanEval_66_Transformed.calculateUppercaseAsciiSum(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_66_Source.digitSum(testCases[6]), 
                     HumanEval_66_Transformed.calculateUppercaseAsciiSum(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_66_Source.digitSum(testCases[7]), 
                     HumanEval_66_Transformed.calculateUppercaseAsciiSum(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_66_Source.digitSum(testCases[8]), 
                     HumanEval_66_Transformed.calculateUppercaseAsciiSum(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_66_Source.digitSum(testCases[9]), 
                     HumanEval_66_Transformed.calculateUppercaseAsciiSum(testCases[9]));
    }
}