import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HumanEval_88 {

    // Source Code
    static class HumanEval_88_Source {
        public static int[] sortArray(int[] array) {
            if (array.length == 0) {
                return new int[0];
            }
            
            boolean reverse = (array[0] + array[array.length - 1]) % 2 == 0;
            Arrays.sort(array);
            
            if (reverse) {
                for (int i = 0; i < array.length / 2; i++) {
                    int temp = array[i];
                    array[i] = array[array.length - 1 - i];
                    array[array.length - 1 - i] = temp;
                }
            }
            
            return array;
        }
    }

    // Transformed Code
    static class HumanEval_88_Transformed {
        public static int[] arrangeSequence(int[] sequence) {
            if (sequence.length == 0) {
                return new int[0];
            }
            
            boolean reverseOrder = (sequence[0] + sequence[sequence.length - 1]) % 2 == 0;
            Arrays.sort(sequence);
            
            if (reverseOrder) {
                for (int i = 0; i < sequence.length / 2; i++) {
                    int temp = sequence[i];
                    sequence[i] = sequence[sequence.length - 1 - i];
                    sequence[sequence.length - 1 - i] = temp;
                }
            }
            
            return sequence;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {3, 1, 4, 1, 5, 9},
        {10, 20, 30, 40, 50},
        {5, 3, 8, 6, 7, 2},
        {7, 2, 9, 4, 6},
        {1},
        {},
        {2, 4, 6, 8, 10},
        {9, 7, 5, 3, 1},
        {11, 22, 33, 44, 55},
        {100, 200, 300, 400, 500}
    };

    @Test
    public void test_0() {
        assertArrayEquals(HumanEval_88_Source.sortArray(testCases[0]), HumanEval_88_Transformed.arrangeSequence(testCases[0].clone()));
    }

    @Test
    public void test_1() {
        assertArrayEquals(HumanEval_88_Source.sortArray(testCases[1]), HumanEval_88_Transformed.arrangeSequence(testCases[1].clone()));
    }

    @Test
    public void test_2() {
        assertArrayEquals(HumanEval_88_Source.sortArray(testCases[2]), HumanEval_88_Transformed.arrangeSequence(testCases[2].clone()));
    }

    @Test
    public void test_3() {
        assertArrayEquals(HumanEval_88_Source.sortArray(testCases[3]), HumanEval_88_Transformed.arrangeSequence(testCases[3].clone()));
    }

    @Test
    public void test_4() {
        assertArrayEquals(HumanEval_88_Source.sortArray(testCases[4]), HumanEval_88_Transformed.arrangeSequence(testCases[4].clone()));
    }

    @Test
    public void test_5() {
        assertArrayEquals(HumanEval_88_Source.sortArray(testCases[5]), HumanEval_88_Transformed.arrangeSequence(testCases[5].clone()));
    }

    @Test
    public void test_6() {
        assertArrayEquals(HumanEval_88_Source.sortArray(testCases[6]), HumanEval_88_Transformed.arrangeSequence(testCases[6].clone()));
    }

    @Test
    public void test_7() {
        assertArrayEquals(HumanEval_88_Source.sortArray(testCases[7]), HumanEval_88_Transformed.arrangeSequence(testCases[7].clone()));
    }

    @Test
    public void test_8() {
        assertArrayEquals(HumanEval_88_Source.sortArray(testCases[8]), HumanEval_88_Transformed.arrangeSequence(testCases[8].clone()));
    }

    @Test
    public void test_9() {
        assertArrayEquals(HumanEval_88_Source.sortArray(testCases[9]), HumanEval_88_Transformed.arrangeSequence(testCases[9].clone()));
    }
}