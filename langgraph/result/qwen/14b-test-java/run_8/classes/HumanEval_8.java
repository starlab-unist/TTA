import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HumanEval_8 {

    // Source Code
    static class HumanEval_8_Source {
        public static int[] sumProduct(List<Integer> numbers) {
            int sumValue = 0;
            int prodValue = 1;

            for (int n : numbers) {
                sumValue += n;
                prodValue *= n;
            }
            return new int[]{sumValue, prodValue};
        }
    }

    // Transformed Code
    static class HumanEval_8_Transformed {
        public static int[] calculateAggregates(List<Integer> values) {
            int totalSum = 0;
            int cumulativeProduct = 1;

            int index = 0;
            while (index < values.size()) {
                totalSum += values.get(index);
                cumulativeProduct *= values.get(index);
                index++;
            }

            return new int[]{totalSum, cumulativeProduct};
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(), new int[]{0, 1}},
        {Arrays.asList(1), new int[]{1, 1}},
        {Arrays.asList(2, 3), new int[]{5, 6}},
        {Arrays.asList(4, 5, 6), new int[]{15, 120}},
        {Arrays.asList(7, 8, 9, 10), new int[]{34, 5040}},
        {Arrays.asList(0, 1, 2, 3), new int[]{6, 0}},
        {Arrays.asList(1, -1, 1, -1), new int[]{0, 1}},
        {Arrays.asList(10, 20, 30), new int[]{60, 6000}},
        {Arrays.asList(5, 5, 5, 5), new int[]{20, 625}},
        {Arrays.asList(1, 2, 3, 4, 5), new int[]{15, 120}}
    };

    @Test
    public void test_0() {
        assertArrayEquals(HumanEval_8_Source.sumProduct((List<Integer>) testCases[0][0]), 
                          HumanEval_8_Transformed.calculateAggregates((List<Integer>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertArrayEquals(HumanEval_8_Source.sumProduct((List<Integer>) testCases[1][0]), 
                          HumanEval_8_Transformed.calculateAggregates((List<Integer>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertArrayEquals(HumanEval_8_Source.sumProduct((List<Integer>) testCases[2][0]), 
                          HumanEval_8_Transformed.calculateAggregates((List<Integer>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertArrayEquals(HumanEval_8_Source.sumProduct((List<Integer>) testCases[3][0]), 
                          HumanEval_8_Transformed.calculateAggregates((List<Integer>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertArrayEquals(HumanEval_8_Source.sumProduct((List<Integer>) testCases[4][0]), 
                          HumanEval_8_Transformed.calculateAggregates((List<Integer>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertArrayEquals(HumanEval_8_Source.sumProduct((List<Integer>) testCases[5][0]), 
                          HumanEval_8_Transformed.calculateAggregates((List<Integer>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertArrayEquals(HumanEval_8_Source.sumProduct((List<Integer>) testCases[6][0]), 
                          HumanEval_8_Transformed.calculateAggregates((List<Integer>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertArrayEquals(HumanEval_8_Source.sumProduct((List<Integer>) testCases[7][0]), 
                          HumanEval_8_Transformed.calculateAggregates((List<Integer>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertArrayEquals(HumanEval_8_Source.sumProduct((List<Integer>) testCases[8][0]), 
                          HumanEval_8_Transformed.calculateAggregates((List<Integer>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertArrayEquals(HumanEval_8_Source.sumProduct((List<Integer>) testCases[9][0]), 
                          HumanEval_8_Transformed.calculateAggregates((List<Integer>) testCases[9][0]));
    }
}