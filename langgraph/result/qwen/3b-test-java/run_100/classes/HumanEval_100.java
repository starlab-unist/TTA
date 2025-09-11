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
    public static int[] constructStack(int size) {
        int[] pile = new int[size];
        int index = 0;
        while (index < size) {
            pile[index] = size + 2 * index;
            index++;
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
        assertEquals(listToArray(makeAPile(testCases[0])), constructStack(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(listToArray(makeAPile(testCases[1])), constructStack(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(listToArray(makeAPile(testCases[2])), constructStack(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(listToArray(makeAPile(testCases[3])), constructStack(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(listToArray(makeAPile(testCases[4])), constructStack(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(listToArray(makeAPile(testCases[5])), constructStack(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(listToArray(makeAPile(testCases[6])), constructStack(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(listToArray(makeAPile(testCases[7])), constructStack(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(listToArray(makeAPile(testCases[8])), constructStack(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(listToArray(makeAPile(testCases[9])), constructStack(testCases[9]));
    }

    // Helper method to convert List<Integer> to int[]
    private static int[] listToArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}