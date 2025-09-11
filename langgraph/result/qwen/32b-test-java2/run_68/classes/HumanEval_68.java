import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_68 {

    // Source Code
    static class HumanEval_68_Source {
        public static List<Integer> pluck(List<Integer> arr) {
            if (arr.isEmpty()) return new ArrayList<>();
            
            List<Integer> evens = new ArrayList<>();
            for (Integer x : arr) {
                if (x % 2 == 0) {
                    evens.add(x);
                }
            }
            
            if (evens.isEmpty()) return new ArrayList<>();
            
            int minEven = Integer.MAX_VALUE;
            for (Integer even : evens) {
                if (even < minEven) {
                    minEven = even;
                }
            }
            
            int index = arr.indexOf(minEven);
            List<Integer> result = new ArrayList<>();
            result.add(minEven);
            result.add(index);
            
            return result;
        }
    }

    // Transformed Code
    static class HumanEval_68_Transformed {
        public List<Integer> extractMinEvenAndIndex(List<Integer> sequence) {
            if (sequence.isEmpty()) {
                return new ArrayList<>();
            }

            List<Integer> evenNumbers = new ArrayList<>();
            for (int num : sequence) {
                if (num % 2 == 0) {
                    evenNumbers.add(num);
                }
            }
            if (evenNumbers.isEmpty()) {
                return new ArrayList<>();
            }

            int smallestEven = Integer.MAX_VALUE;
            for (int num : evenNumbers) {
                if (num < smallestEven) {
                    smallestEven = num;
                }
            }

            int positionOfSmallestEven = sequence.indexOf(smallestEven);

            List<Integer> result = new ArrayList<>();
            result.add(smallestEven);
            result.add(positionOfSmallestEven);
            return result;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {List.of(1, 2, 3, 4, 5), List.of(2, 1)},
        {List.of(10, 21, 3, 7, 8), List.of(8, 4)},
        {List.of(), List.of()},
        {List.of(1, 3, 5, 7), List.of()},
        {List.of(2, 4, 6, 8), List.of(2, 0)},
        {List.of(9, 7, 5, 3, 2, 4, 6, 8), List.of(2, 4)},
        {List.of(0, 1, 2, 3, 4, 5), List.of(0, 0)},
        {List.of(11, 13, 17, 19, 23, 29, 2), List.of(2, 6)},
        {List.of(8, 6, 4, 2, 0), List.of(0, 4)},
        {List.of(2, 2, 2, 2, 2), List.of(2, 0)}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_68_Source.pluck((List<Integer>) testCases[0][0]), 
                     new HumanEval_68_Transformed().extractMinEvenAndIndex((List<Integer>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_68_Source.pluck((List<Integer>) testCases[1][0]), 
                     new HumanEval_68_Transformed().extractMinEvenAndIndex((List<Integer>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_68_Source.pluck((List<Integer>) testCases[2][0]), 
                     new HumanEval_68_Transformed().extractMinEvenAndIndex((List<Integer>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_68_Source.pluck((List<Integer>) testCases[3][0]), 
                     new HumanEval_68_Transformed().extractMinEvenAndIndex((List<Integer>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_68_Source.pluck((List<Integer>) testCases[4][0]), 
                     new HumanEval_68_Transformed().extractMinEvenAndIndex((List<Integer>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_68_Source.pluck((List<Integer>) testCases[5][0]), 
                     new HumanEval_68_Transformed().extractMinEvenAndIndex((List<Integer>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_68_Source.pluck((List<Integer>) testCases[6][0]), 
                     new HumanEval_68_Transformed().extractMinEvenAndIndex((List<Integer>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_68_Source.pluck((List<Integer>) testCases[7][0]), 
                     new HumanEval_68_Transformed().extractMinEvenAndIndex((List<Integer>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_68_Source.pluck((List<Integer>) testCases[8][0]), 
                     new HumanEval_68_Transformed().extractMinEvenAndIndex((List<Integer>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_68_Source.pluck((List<Integer>) testCases[9][0]), 
                     new HumanEval_68_Transformed().extractMinEvenAndIndex((List<Integer>) testCases[9][0]));
    }
}