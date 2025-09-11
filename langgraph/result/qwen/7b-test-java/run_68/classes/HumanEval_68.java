import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_68 {

    // Source Code
    static class HumanEval_68_Source {
        public static List<Integer> pluck(List<Integer> arr) {
            if (arr.isEmpty()) return new ArrayList<>();
            
            List<Integer> evens = new ArrayList<>();
            for (int x : arr) {
                if (x % 2 == 0) {
                    evens.add(x);
                }
            }
            
            if (evens.isEmpty()) return new ArrayList<>();
            
            int minEven = Collections.min(evens);
            int index = arr.indexOf(minEven);
            
            return Arrays.asList(minEven, index);
        }
    }

    // Transformed Code
    static class HumanEval_68_Transformed {
        public static ArrayList<Integer> extractMinEvenAndIndex(ArrayList<Integer> sequence) {
            if (sequence.isEmpty()) {
                return new ArrayList<>();
            }

            ArrayList<Integer> evenNumbers = new ArrayList<>();
            for (int num : sequence) {
                if (num % 2 == 0) {
                    evenNumbers.add(num);
                }
            }

            if (evenNumbers.isEmpty()) {
                return new ArrayList<>();
            }

            int smallestEven = Collections.min(evenNumbers);
            int positionOfSmallestEven = sequence.indexOf(smallestEven);

            return new ArrayList<>(Arrays.asList(smallestEven, positionOfSmallestEven));
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(2, 1)},
        {Arrays.asList(10, 21, 3, 7, 8), Arrays.asList(8, 4)},
        {new ArrayList<>(), new ArrayList<>()},
        {Arrays.asList(1, 3, 5, 7), new ArrayList<>()},
        {Arrays.asList(2, 4, 6, 8), Arrays.asList(2, 0)},
        {Arrays.asList(9, 7, 5, 3, 2, 4, 6, 8), Arrays.asList(2, 4)},
        {Arrays.asList(0, 1, 2, 3, 4, 5), Arrays.asList(0, 0)},
        {Arrays.asList(11, 13, 17, 19, 23, 29, 2), Arrays.asList(2, 6)},
        {Arrays.asList(8, 6, 4, 2, 0), Arrays.asList(0, 4)},
        {Arrays.asList(2, 2, 2, 2, 2), Arrays.asList(2, 0)}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_68_Source.pluck((List<Integer>) testCases[0][0]), 
                     HumanEval_68_Transformed.extractMinEvenAndIndex(new ArrayList<>((List<Integer>) testCases[0][0])));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_68_Source.pluck((List<Integer>) testCases[1][0]), 
                     HumanEval_68_Transformed.extractMinEvenAndIndex(new ArrayList<>((List<Integer>) testCases[1][0])));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_68_Source.pluck((List<Integer>) testCases[2][0]), 
                     HumanEval_68_Transformed.extractMinEvenAndIndex(new ArrayList<>((List<Integer>) testCases[2][0])));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_68_Source.pluck((List<Integer>) testCases[3][0]), 
                     HumanEval_68_Transformed.extractMinEvenAndIndex(new ArrayList<>((List<Integer>) testCases[3][0])));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_68_Source.pluck((List<Integer>) testCases[4][0]), 
                     HumanEval_68_Transformed.extractMinEvenAndIndex(new ArrayList<>((List<Integer>) testCases[4][0])));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_68_Source.pluck((List<Integer>) testCases[5][0]), 
                     HumanEval_68_Transformed.extractMinEvenAndIndex(new ArrayList<>((List<Integer>) testCases[5][0])));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_68_Source.pluck((List<Integer>) testCases[6][0]), 
                     HumanEval_68_Transformed.extractMinEvenAndIndex(new ArrayList<>((List<Integer>) testCases[6][0])));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_68_Source.pluck((List<Integer>) testCases[7][0]), 
                     HumanEval_68_Transformed.extractMinEvenAndIndex(new ArrayList<>((List<Integer>) testCases[7][0])));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_68_Source.pluck((List<Integer>) testCases[8][0]), 
                     HumanEval_68_Transformed.extractMinEvenAndIndex(new ArrayList<>((List<Integer>) testCases[8][0])));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_68_Source.pluck((List<Integer>) testCases[9][0]), 
                     HumanEval_68_Transformed.extractMinEvenAndIndex(new ArrayList<>((List<Integer>) testCases[9][0])));
    }
}