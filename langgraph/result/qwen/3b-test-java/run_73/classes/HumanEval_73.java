import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_73 {

    // Source Code
    static class HumanEval_73_Source {
        public static int smallestChange(int[] arr) {
            int ans = 0;
            for (int i = 0; i < arr.length / 2; i++) {
                if (arr[i] != arr[arr.length - i - 1]) {
                    ans++;
                }
            }
            return ans;
        }
    }

    // Transformed Code
    static class HumanEval_73_Transformed {
        public static int minimalAdjustments(int[] sequence) {
            int adjustmentsNeeded = 0;
            int index = 0;
            while (index < sequence.length / 2) {
                if (sequence[index] != sequence[sequence.length - index - 1]) {
                    adjustmentsNeeded++;
                }
                index++;
            }
            return adjustmentsNeeded;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new int[]{1, 2, 3, 2, 1}},       // Palindrome with odd length
        {new int[]{1, 2, 3, 4, 5}},       // Not a palindrome
        {new int[]{'a', 'b', 'c', 'b', 'a'}}, // Palindrome with odd length and strings (will not compile, use char array)
        {new int[]{1, 1, 1, 1, 1}},       // All elements are the same
        {new int[]{1, 2, 2, 1}},          // Palindrome with even length
        {new int[]{1, 2, 3}},             // Not a palindrome
        {new int[]{}},                    // Empty list
        {new int[]{1}},                   // Single element
        {new int[]{1, 2}},                // Not a palindrome
        {new int[]{1, 2, 3, 4}}           // Not a palindrome
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_73_Source.smallestChange((int[]) testCases[0][0]), 
                     HumanEval_73_Transformed.minimalAdjustments((int[]) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_73_Source.smallestChange((int[]) testCases[1][0]), 
                     HumanEval_73_Transformed.minimalAdjustments((int[]) testCases[1][0]));
    }

    @Test
    public void test_2() {
        // The original code uses int[] for all inputs, so we need to convert char array to int array or use a different approach.
        // For simplicity, let's assume the input should be int[], and this test case will not work as is with characters.
        assertEquals(HumanEval_73_Source.smallestChange((int[]) testCases[2][0]), 
                     HumanEval_73_Transformed.minimalAdjustments((int[]) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_73_Source.smallestChange((int[]) testCases[3][0]), 
                     HumanEval_73_Transformed.minimalAdjustments((int[]) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_73_Source.smallestChange((int[]) testCases[4][0]), 
                     HumanEval_73_Transformed.minimalAdjustments((int[]) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_73_Source.smallestChange((int[]) testCases[5][0]), 
                     HumanEval_73_Transformed.minimalAdjustments((int[]) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_73_Source.smallestChange((int[]) testCases[6][0]), 
                     HumanEval_73_Transformed.minimalAdjustments((int[]) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_73_Source.smallestChange((int[]) testCases[7][0]), 
                     HumanEval_73_Transformed.minimalAdjustments((int[]) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_73_Source.smallestChange((int[]) testCases[8][0]), 
                     HumanEval_73_Transformed.minimalAdjustments((int[]) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_73_Source.smallestChange((int[]) testCases[9][0]), 
                     HumanEval_73_Transformed.minimalAdjustments((int[]) testCases[9][0]));
    }
}