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

        public static int smallestChange(String[] arr) {
            int ans = 0;
            for (int i = 0; i < arr.length / 2; i++) {
                if (!arr[i].equals(arr[arr.length - i - 1])) {
                    ans++;
                }
            }
            return ans;
        }
    }

    // Transformed Code
    static class HumanEval_73_Transformed {
        public int minimalAdjustments(int[] sequence) {
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

        public int minimalAdjustments(String[] sequence) {
            int adjustmentsNeeded = 0;
            int index = 0;
            while (index < sequence.length / 2) {
                if (!sequence[index].equals(sequence[sequence.length - index - 1])) {
                    adjustmentsNeeded++;
                }
                index++;
            }
            return adjustmentsNeeded;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new int[]{1, 2, 3, 2, 1}, null, 0},
        {new int[]{1, 2, 3, 4, 5}, null, 2},
        {new String[]{"a", "b", "c", "b", "a"}, null, 0},
        {new int[]{1, 1, 1, 1, 1}, null, 0},
        {new int[]{1, 2, 2, 1}, null, 0},
        {new int[]{1, 2, 3}, null, 1},
        {new int[]{}, null, 0},
        {new int[]{1}, null, 0},
        {new int[]{1, 2}, null, 1},
        {new int[]{1, 2, 3, 4}, null, 2}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_73_Source.smallestChange((int[]) testCases[0][0]), 
                     new HumanEval_73_Transformed().minimalAdjustments((int[]) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_73_Source.smallestChange((int[]) testCases[1][0]), 
                     new HumanEval_73_Transformed().minimalAdjustments((int[]) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_73_Source.smallestChange((String[]) testCases[2][0]), 
                     new HumanEval_73_Transformed().minimalAdjustments((String[]) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_73_Source.smallestChange((int[]) testCases[3][0]), 
                     new HumanEval_73_Transformed().minimalAdjustments((int[]) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_73_Source.smallestChange((int[]) testCases[4][0]), 
                     new HumanEval_73_Transformed().minimalAdjustments((int[]) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_73_Source.smallestChange((int[]) testCases[5][0]), 
                     new HumanEval_73_Transformed().minimalAdjustments((int[]) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_73_Source.smallestChange((int[]) testCases[6][0]), 
                     new HumanEval_73_Transformed().minimalAdjustments((int[]) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_73_Source.smallestChange((int[]) testCases[7][0]), 
                     new HumanEval_73_Transformed().minimalAdjustments((int[]) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_73_Source.smallestChange((int[]) testCases[8][0]), 
                     new HumanEval_73_Transformed().minimalAdjustments((int[]) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_73_Source.smallestChange((int[]) testCases[9][0]), 
                     new HumanEval_73_Transformed().minimalAdjustments((int[]) testCases[9][0]));
    }
}