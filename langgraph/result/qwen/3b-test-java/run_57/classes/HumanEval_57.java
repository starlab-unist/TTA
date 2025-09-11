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

public class HumanEval_57 {

    // Source Code
    public static boolean monotonic(List<Integer> l) {
        if (l.equals(new ArrayList<>(Collections.sort(l))) || l.equals(new ArrayList<>(Collections.sort(l).reverse()))) {
            return true;
        }
        return false;
    }

    // Transformed Code
    public static boolean checkMonotonicSequence(List<Integer> sequence) {
        List<Integer> ascending = new ArrayList<>(sequence);
        List<Integer> descending = new ArrayList<>(sequence);

        Collections.sort(ascending);
        Collections.sort(descending, Collections.reverseOrder());

        return sequence.equals(ascending) || sequence.equals(descending);
    }

    // Test Cases
    private static final List<List<Integer>> testCases = Arrays.asList(
        Arrays.asList(1, 2, 3, 4, 5),       // strictly increasing
        Arrays.asList(5, 4, 3, 2, 1),       // strictly decreasing
        Arrays.asList(1, 1, 1, 1, 1),       // all elements are the same
        Arrays.asList(1, 2, 2, 3, 4),       // non-decreasing
        Arrays.asList(5, 5, 4, 4, 3, 2, 1), // non-increasing
        Arrays.asList(1, 3, 2),             // not monotonic
        Arrays.asList(),                    // empty list
        Arrays.asList(10),                  // single element
        Arrays.asList(3, 3, 2, 1, 1, 1),    // decreasing with duplicates
        Arrays.asList(1, 1, 2, 2, 3, 3)     // increasing with duplicates
    );

    @Test
    public void test_0() {
        assertEquals(monotonic(testCases.get(0)), checkMonotonicSequence(testCases.get(0)));
    }

    @Test
    public void test_1() {
        assertEquals(monotonic(testCases.get(1)), checkMonotonicSequence(testCases.get(1)));
    }

    @Test
    public void test_2() {
        assertEquals(monotonic(testCases.get(2)), checkMonotonicSequence(testCases.get(2)));
    }

    @Test
    public void test_3() {
        assertEquals(monotonic(testCases.get(3)), checkMonotonicSequence(testCases.get(3)));
    }

    @Test
    public void test_4() {
        assertEquals(monotonic(testCases.get(4)), checkMonotonicSequence(testCases.get(4)));
    }

    @Test
    public void test_5() {
        assertEquals(monotonic(testCases.get(5)), checkMonotonicSequence(testCases.get(5)));
    }

    @Test
    public void test_6() {
        assertEquals(monotonic(testCases.get(6)), checkMonotonicSequence(testCases.get(6)));
    }

    @Test
    public void test_7() {
        assertEquals(monotonic(testCases.get(7)), checkMonotonicSequence(testCases.get(7)));
    }

    @Test
    public void test_8() {
        assertEquals(monotonic(testCases.get(8)), checkMonotonicSequence(testCases.get(8)));
    }

    @Test
    public void test_9() {
        assertEquals(monotonic(testCases.get(9)), checkMonotonicSequence(testCases.get(9)));
    }
}