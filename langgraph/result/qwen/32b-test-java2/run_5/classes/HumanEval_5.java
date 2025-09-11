import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_5 {

    // Source Code
    static class HumanEval_5_Source {
        public static List<Integer> intersperse(List<Integer> numbers, int delimiter) {
            if (numbers.isEmpty()) {
                return new ArrayList<>();
            }

            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < numbers.size() - 1; i++) {
                result.add(numbers.get(i));
                result.add(delimiter);
            }

            result.add(numbers.get(numbers.size() - 1));

            return result;
        }
    }

    // Transformed Code
    static class HumanEval_5_Transformed {
        public static List<Integer> weaveNumbers(List<Integer> sequence, int separator) {
            if (sequence.isEmpty()) {
                return new ArrayList<>();
            }

            List<Integer> interleaved = new ArrayList<>();
            int index = 0;

            while (index < sequence.size() - 1) {
                interleaved.add(sequence.get(index));
                interleaved.add(separator);
                index++;
            }

            interleaved.add(sequence.get(sequence.size() - 1));

            return interleaved;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(1, 2, 3), 0},
        {Arrays.asList(5, 6, 7, 8), -1},
        {Arrays.asList(10), 5},
        {new ArrayList<>(), 3},
        {Arrays.asList(1, 1, 1, 1), 2},
        {Arrays.asList(9, 8, 7), 4},
        {Arrays.asList(2, 4, 6, 8, 10), 1},
        {Arrays.asList(3, 3, 3), 3},
        {Arrays.asList(5), 5},
        {Arrays.asList(7, 8), 9}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_5_Source.intersperse((List<Integer>) testCases[0][0], (int) testCases[0][1]), 
                     HumanEval_5_Transformed.weaveNumbers((List<Integer>) testCases[0][0], (int) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_5_Source.intersperse((List<Integer>) testCases[1][0], (int) testCases[1][1]), 
                     HumanEval_5_Transformed.weaveNumbers((List<Integer>) testCases[1][0], (int) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_5_Source.intersperse((List<Integer>) testCases[2][0], (int) testCases[2][1]), 
                     HumanEval_5_Transformed.weaveNumbers((List<Integer>) testCases[2][0], (int) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_5_Source.intersperse((List<Integer>) testCases[3][0], (int) testCases[3][1]), 
                     HumanEval_5_Transformed.weaveNumbers((List<Integer>) testCases[3][0], (int) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_5_Source.intersperse((List<Integer>) testCases[4][0], (int) testCases[4][1]), 
                     HumanEval_5_Transformed.weaveNumbers((List<Integer>) testCases[4][0], (int) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_5_Source.intersperse((List<Integer>) testCases[5][0], (int) testCases[5][1]), 
                     HumanEval_5_Transformed.weaveNumbers((List<Integer>) testCases[5][0], (int) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_5_Source.intersperse((List<Integer>) testCases[6][0], (int) testCases[6][1]), 
                     HumanEval_5_Transformed.weaveNumbers((List<Integer>) testCases[6][0], (int) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_5_Source.intersperse((List<Integer>) testCases[7][0], (int) testCases[7][1]), 
                     HumanEval_5_Transformed.weaveNumbers((List<Integer>) testCases[7][0], (int) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_5_Source.intersperse((List<Integer>) testCases[8][0], (int) testCases[8][1]), 
                     HumanEval_5_Transformed.weaveNumbers((List<Integer>) testCases[8][0], (int) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_5_Source.intersperse((List<Integer>) testCases[9][0], (int) testCases[9][1]), 
                     HumanEval_5_Transformed.weaveNumbers((List<Integer>) testCases[9][0], (int) testCases[9][1]));
    }
}