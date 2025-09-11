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

public class HumanEval_30 {

    // Source Code
    public static List<Integer> getPositive(List<Integer> l) {
        List<Integer> result = new ArrayList<>();
        for (Integer e : l) {
            if (e > 0) {
                result.add(e);
            }
        }
        return result;
    }

    // Transformed Code
    public static List<Integer> extract_positive_numbers(List<Integer> input_list) {
        List<Integer> positive_numbers = new ArrayList<>();
        int index = 0;

        while (index < input_list.size()) {
            if (input_list.get(index) > 0) {
                positive_numbers.add(input_list.get(index));
            }
            index++;
        }

        return positive_numbers;
    }

    // Test Cases
    private static final List<List<Integer>> testCases = Arrays.asList(
        Arrays.asList(1, -2, 3, 4, -5),
        Arrays.asList(-1, -2, -3, -4, -5),
        Arrays.asList(0, 0, 0, 0),
        Arrays.asList(10, 20, 30, 40, 50),
        new ArrayList<>(),
        Arrays.asList(-10, 0, 10),
        Arrays.asList(5),
        Arrays.asList(-5),
        Arrays.asList(1, 2, 3, 4, 5, -6, -7, -8, -9, -10),
        Arrays.asList(100, 200, 300, -100, -200, -300)
    );

    @Test
    public void test_0() {
        assertEquals(getPositive(testCases.get(0)), extract_positive_numbers(testCases.get(0)));
    }

    @Test
    public void test_1() {
        assertEquals(getPositive(testCases.get(1)), extract_positive_numbers(testCases.get(1)));
    }

    @Test
    public void test_2() {
        assertEquals(getPositive(testCases.get(2)), extract_positive_numbers(testCases.get(2)));
    }

    @Test
    public void test_3() {
        assertEquals(getPositive(testCases.get(3)), extract_positive_numbers(testCases.get(3)));
    }

    @Test
    public void test_4() {
        assertEquals(getPositive(testCases.get(4)), extract_positive_numbers(testCases.get(4)));
    }

    @Test
    public void test_5() {
        assertEquals(getPositive(testCases.get(5)), extract_positive_numbers(testCases.get(5)));
    }

    @Test
    public void test_6() {
        assertEquals(getPositive(testCases.get(6)), extract_positive_numbers(testCases.get(6)));
    }

    @Test
    public void test_7() {
        assertEquals(getPositive(testCases.get(7)), extract_positive_numbers(testCases.get(7)));
    }

    @Test
    public void test_8() {
        assertEquals(getPositive(testCases.get(8)), extract_positive_numbers(testCases.get(8)));
    }

    @Test
    public void test_9() {
        assertEquals(getPositive(testCases.get(9)), extract_positive_numbers(testCases.get(9)));
    }
}