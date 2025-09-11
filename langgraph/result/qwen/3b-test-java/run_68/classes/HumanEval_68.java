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

public class HumanEval_68 {

    // Source Code
    public static int[] pluck(int[] arr) {
        if (arr.length == 0) {
            return new int[0];
        }

        int[] evens = Arrays.stream(arr)
                            .filter(x -> x % 2 == 0)
                            .toArray();

        if (evens.length == 0) {
            return new int[0];
        }

        int minEven = Arrays.stream(evens).min().getAsInt();
        int index = Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new)).indexOf(minEven);

        return new int[]{minEven, index};
    }

    // Transformed Code
    public static List<Integer> extractMinEvenAndIndex(List<Integer> sequence) {
        if (sequence == null || sequence.isEmpty()) {
            return List.of();
        }

        List<Integer> evenNumbers = new ArrayList<>();
        for (int num : sequence) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            }
        }

        if (evenNumbers.isEmpty()) {
            return List.of();
        }

        int smallestEven = Collections.min(evenNumbers);
        int positionOfSmallestEven = sequence.indexOf(smallestEven);

        return List.of(smallestEven, positionOfSmallestEven);
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new int[]{1, 2, 3, 4, 5}, Arrays.asList(2, 1)},
        {new int[]{10, 21, 3, 7, 8}, Arrays.asList(8, 4)},
        {new int[]{}, List.of()},
        {new int[]{1, 3, 5, 7}, List.of()},
        {new int[]{2, 4, 6, 8}, Arrays.asList(2, 0)},
        {new int[]{9, 7, 5, 3, 2, 4, 6, 8}, Arrays.asList(2, 4)},
        {new int[]{0, 1, 2, 3, 4, 5}, Arrays.asList(0, 0)},
        {new int[]{11, 13, 17, 19, 23, 29, 2}, Arrays.asList(2, 6)},
        {new int[]{8, 6, 4, 2, 0}, Arrays.asList(0, 4)},
        {new int[]{2, 2, 2, 2, 2}, Arrays.asList(2, 0)}
    };

    @Test
    public void test_0() {
        assertEquals(Arrays.toString(pluck((int[]) testCases[0][0])), 
                     extractMinEvenAndIndex(Arrays.stream((int[]) testCases[0][0]).boxed().toList()).toString());
    }

    @Test
    public void test_1() {
        assertEquals(Arrays.toString(pluck((int[]) testCases[1][0])), 
                     extractMinEvenAndIndex(Arrays.stream((int[]) testCases[1][0]).boxed().toList()).toString());
    }

    @Test
    public void test_2() {
        assertEquals(Arrays.toString(pluck((int[]) testCases[2][0])), 
                     extractMinEvenAndIndex(Arrays.stream((int[]) testCases[2][0]).boxed().toList()).toString());
    }

    @Test
    public void test_3() {
        assertEquals(Arrays.toString(pluck((int[]) testCases[3][0])), 
                     extractMinEvenAndIndex(Arrays.stream((int[]) testCases[3][0]).boxed().toList()).toString());
    }

    @Test
    public void test_4() {
        assertEquals(Arrays.toString(pluck((int[]) testCases[4][0])), 
                     extractMinEvenAndIndex(Arrays.stream((int[]) testCases[4][0]).boxed().toList()).toString());
    }

    @Test
    public void test_5() {
        assertEquals(Arrays.toString(pluck((int[]) testCases[5][0])), 
                     extractMinEvenAndIndex(Arrays.stream((int[]) testCases[5][0]).boxed().toList()).toString());
    }

    @Test
    public void test_6() {
        assertEquals(Arrays.toString(pluck((int[]) testCases[6][0])), 
                     extractMinEvenAndIndex(Arrays.stream((int[]) testCases[6][0]).boxed().toList()).toString());
    }

    @Test
    public void test_7() {
        assertEquals(Arrays.toString(pluck((int[]) testCases[7][0])), 
                     extractMinEvenAndIndex(Arrays.stream((int[]) testCases[7][0]).boxed().toList()).toString());
    }

    @Test
    public void test_8() {
        assertEquals(Arrays.toString(pluck((int[]) testCases[8][0])), 
                     extractMinEvenAndIndex(Arrays.stream((int[]) testCases[8][0]).boxed().toList()).toString());
    }

    @Test
    public void test_9() {
        assertEquals(Arrays.toString(pluck((int[]) testCases[9][0])), 
                     extractMinEvenAndIndex(Arrays.stream((int[]) testCases[9][0]).boxed().toList()).toString());
    }
}