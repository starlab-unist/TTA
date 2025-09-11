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

public class HumanEval_106 {

    // Source Code
    public static int[] f(int n) {
        int[] ret = new int[n];
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                int x = 1;
                for (int j = 1; j <= i; j++) {
                    x *= j;
                }
                ret[i - 1] = x;
            } else {
                int x = 0;
                for (int j = 1; j <= i; j++) {
                    x += j;
                }
                ret[i - 1] = x;
            }
        }
        return ret;
    }

    // Transformed Code
    public static List<Integer> generateAlternatingSequence(int limit) {
        List<Integer> result = new ArrayList<>();
        int index = 1;
        while (index <= limit) {
            if (index % 2 == 0) {
                int factorial = calculateFactorial(index);
                result.add(factorial);
            } else {
                int summation = calculateSummation(index);
                result.add(summation);
            }
            index++;
        }
        return result;
    }

    private static int calculateFactorial(int number) {
        int factorial = 1;
        int innerIndex = 1;
        while (innerIndex <= number) {
            factorial *= innerIndex;
            innerIndex++;
        }
        return factorial;
    }

    private static int calculateSummation(int number) {
        int summation = 0;
        int innerIndex = 1;
        while (innerIndex <= number) {
            summation += innerIndex;
            innerIndex++;
        }
        return summation;
    }

    // Test Cases
    @Test
    public void test_0() {
        assertEquals(Arrays.toString(f(0)), generateAlternatingSequence(0).toString());
    }

    @Test
    public void test_1() {
        assertEquals(Arrays.toString(f(1)), generateAlternatingSequence(1).toString());
    }

    @Test
    public void test_2() {
        assertEquals(Arrays.toString(f(2)), generateAlternatingSequence(2).toString());
    }

    @Test
    public void test_3() {
        assertEquals(Arrays.toString(f(3)), generateAlternatingSequence(3).toString());
    }

    @Test
    public void test_4() {
        assertEquals(Arrays.toString(f(4)), generateAlternatingSequence(4).toString());
    }

    @Test
    public void test_5() {
        assertEquals(Arrays.toString(f(5)), generateAlternatingSequence(5).toString());
    }

    @Test
    public void test_6() {
        assertEquals(Arrays.toString(f(10)), generateAlternatingSequence(10).toString());
    }

    @Test
    public void test_7() {
        assertEquals(Arrays.toString(f(20)), generateAlternatingSequence(20).toString());
    }

    @Test
    public void test_8() {
        assertEquals(Arrays.toString(f(30)), generateAlternatingSequence(30).toString());
    }

    @Test
    public void test_9() {
        assertEquals(Arrays.toString(f(50)), generateAlternatingSequence(50).toString());
    }
}