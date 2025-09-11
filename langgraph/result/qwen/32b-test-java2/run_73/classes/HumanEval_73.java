import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_73 {

    // Source Code
    static class HumanEval_73_Source {
        public int smallestChange(int[] arr) {
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
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new int[]{1, 2, 3, 2, 1}, 0},
        {new int[]{1, 2, 3, 4, 5}, 2},
        {new int[]{1, 1, 1, 1, 1}, 0},
        {new int[]{1, 2, 2, 1}, 0},
        {new int[]{1, 2, 3}, 1},
        {new int[]{}, 0},
        {new int[]{1}, 0},
        {new int[]{1, 2}, 1},
        {new int[]{1, 2, 3, 4}, 2}
    };

    @Test
    public void test_0() {
        assertEquals(new HumanEval_73_Source().smallestChange((int[]) testCases[0][0]), 
                     new HumanEval_73_Transformed().minimalAdjustments((int[]) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_73_Source().smallestChange((int[]) testCases[1][0]), 
                     new HumanEval_73_Transformed().minimalAdjustments((int[]) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_73_Source().smallestChange((int[]) testCases[2][0]), 
                     new HumanEval_73_Transformed().minimalAdjustments((int[]) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_73_Source().smallestChange((int[]) testCases[3][0]), 
                     new HumanEval_73_Transformed().minimalAdjustments((int[]) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_73_Source().smallestChange((int[]) testCases[4][0]), 
                     new HumanEval_73_Transformed().minimalAdjustments((int[]) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_73_Source().smallestChange((int[]) testCases[5][0]), 
                     new HumanEval_73_Transformed().minimalAdjustments((int[]) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_73_Source().smallestChange((int[]) testCases[6][0]), 
                     new HumanEval_73_Transformed().minimalAdjustments((int[]) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_73_Source().smallestChange((int[]) testCases[7][0]), 
                     new HumanEval_73_Transformed().minimalAdjustments((int[]) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_73_Source().smallestChange((int[]) testCases[8][0]), 
                     new HumanEval_73_Transformed().minimalAdjustments((int[]) testCases[8][0]));
    }
}