import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_88 {

    // Source Code
    static class HumanEval_88_Source {
        public static List<Integer> sortArray(List<Integer> array) {
            if (array.isEmpty()) {
                return Arrays.asList();
            } else {
                boolean reverse = (array.get(0) + array.get(array.size() - 1)) % 2 == 0;
                return array.stream().sorted((a, b) -> reverse ? b.compareTo(a) : a.compareTo(b)).toList();
            }
        }
    }

    // Transformed Code
    static class HumanEval_88_Transformed {
        public static List<Integer> arrangeSequence(List<Integer> sequence) {
            if (sequence.isEmpty()) {
                return new ArrayList<>();
            }
            
            boolean reverseOrder = (sequence.get(0) + sequence.get(sequence.size() - 1)) % 2 == 0;
            List<Integer> sortedSequence = new ArrayList<>(sequence);
            Collections.sort(sortedSequence);
            
            if (reverseOrder) {
                Collections.reverse(sortedSequence);
            }
            
            return sortedSequence;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(3, 1, 4, 1, 5, 9)},
        {Arrays.asList(10, 20, 30, 40, 50)},
        {Arrays.asList(5, 3, 8, 6, 7, 2)},
        {Arrays.asList(7, 2, 9, 4, 6)},
        {Arrays.asList(1)},
        {Arrays.asList()},
        {Arrays.asList(2, 4, 6, 8, 10)},
        {Arrays.asList(9, 7, 5, 3, 1)},
        {Arrays.asList(11, 22, 33, 44, 55)},
        {Arrays.asList(100, 200, 300, 400, 500)}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_88_Source.sortArray((List<Integer>) testCases[0][0]), 
                     HumanEval_88_Transformed.arrangeSequence((List<Integer>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_88_Source.sortArray((List<Integer>) testCases[1][0]), 
                     HumanEval_88_Transformed.arrangeSequence((List<Integer>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_88_Source.sortArray((List<Integer>) testCases[2][0]), 
                     HumanEval_88_Transformed.arrangeSequence((List<Integer>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_88_Source.sortArray((List<Integer>) testCases[3][0]), 
                     HumanEval_88_Transformed.arrangeSequence((List<Integer>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_88_Source.sortArray((List<Integer>) testCases[4][0]), 
                     HumanEval_88_Transformed.arrangeSequence((List<Integer>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_88_Source.sortArray((List<Integer>) testCases[5][0]), 
                     HumanEval_88_Transformed.arrangeSequence((List<Integer>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_88_Source.sortArray((List<Integer>) testCases[6][0]), 
                     HumanEval_88_Transformed.arrangeSequence((List<Integer>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_88_Source.sortArray((List<Integer>) testCases[7][0]), 
                     HumanEval_88_Transformed.arrangeSequence((List<Integer>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_88_Source.sortArray((List<Integer>) testCases[8][0]), 
                     HumanEval_88_Transformed.arrangeSequence((List<Integer>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_88_Source.sortArray((List<Integer>) testCases[9][0]), 
                     HumanEval_88_Transformed.arrangeSequence((List<Integer>) testCases[9][0]));
    }
}