import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_80 {

    // Source Code
    public static boolean isHappy(String s) {
        if (s.length() < 3) {
            return false;
        }

        for (int i = 0; i <= s.length() - 3; i++) {
            if (s.charAt(i) == s.charAt(i + 1) || s.charAt(i + 1) == s.charAt(i + 2) || s.charAt(i) == s.charAt(i + 2)) {
                return false;
            }
        }
        return true;
    }

    // Transformed Code
    public static boolean checkHappiness(int[] sequence) {
        if (sequence.length < 3) {
            return false;
        }

        int index = 0;
        while (index < sequence.length - 2) {
            if (sequence[index] == sequence[index + 1] || 
                sequence[index + 1] == sequence[index + 2] || 
                sequence[index] == sequence[index + 2]) {
                return false;
            }
            index++;
        }

        return true;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {"abc", new int[]{97, 98, 99}},       // happy
        {"aabbcc", new int[]{97, 97, 98, 98, 99, 99}},    // not happy
        {"abac", new int[]{97, 98, 97, 99}},      // happy
        {"aaa", new int[]{97, 97, 97}},       // not happy
        {"abcdefg", new int[]{97, 98, 99, 100, 101, 102, 103}},   // happy
        {"a", new int[]{97}},         // not happy (less than 3 characters)
        {"ab", new int[]{97, 98}},        // not happy (less than 3 characters)
        {"aab", new int[]{97, 97, 98}},       // not happy
        {"abcabc", new int[]{97, 98, 99, 97, 98, 99}},    // happy
        {"aabbba", new int[]{97, 97, 98, 98, 98, 97}}     // not happy
    };

    @Test
    public void test_0() {
        assertEquals(isHappy((String) testCases[0][0]), checkHappiness((int[]) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(isHappy((String) testCases[1][0]), checkHappiness((int[]) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(isHappy((String) testCases[2][0]), checkHappiness((int[]) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(isHappy((String) testCases[3][0]), checkHappiness((int[]) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(isHappy((String) testCases[4][0]), checkHappiness((int[]) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(isHappy((String) testCases[5][0]), checkHappiness((int[]) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(isHappy((String) testCases[6][0]), checkHappiness((int[]) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(isHappy((String) testCases[7][0]), checkHappiness((int[]) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(isHappy((String) testCases[8][0]), checkHappiness((int[]) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(isHappy((String) testCases[9][0]), checkHappiness((int[]) testCases[9][1]));
    }
}