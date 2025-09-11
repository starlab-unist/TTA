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

public class HumanEval_100 {

    // Source Code
    public static List<Integer> makeAPile(int n) {
        List<Integer> pile = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pile.add(n + 2 * i);
        }
        return pile;
    }

    // Transformed Code
    public static List<Integer> construct_stack(int size) {
        List<Integer> pile = new ArrayList<>();
        int index = 0;
        while (index < size) {
            pile.add(size + 2 * index);
            index += 1;
        }
        return pile;
    }

    // Test Cases
    private static final int[] testCases = {
        0,
        1,
        2,
        3,
        4,
        5,
        10,
        15,
        20,
        25
    };

    @Test
    public void test_0() {
        assertEquals(makeAPile(testCases[0]), construct_stack(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(makeAPile(testCases[1]), construct_stack(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(makeAPile(testCases[2]), construct_stack(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(makeAPile(testCases[3]), construct_stack(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(makeAPile(testCases[4]), construct_stack(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(makeAPile(testCases[5]), construct_stack(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(makeAPile(testCases[6]), construct_stack(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(makeAPile(testCases[7]), construct_stack(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(makeAPile(testCases[8]), construct_stack(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(makeAPile(testCases[9]), construct_stack(testCases[9]));
    }
}