import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_8 {

    // Source Code
    public static Tuple sumProduct(List<Integer> numbers) {
        int sumValue = 0;
        int prodValue = 1;

        for (int n : numbers) {
            sumValue += n;
            prodValue *= n;
        }

        return new Tuple(sumValue, prodValue);
    }

    // Transformed Code
    public static Tuple calculateAggregates(List<Integer> values) {
        int totalSum = 0;
        int cumulativeProduct = 1;

        int index = 0;
        while (index < values.size()) {
            totalSum += values.get(index);
            cumulativeProduct *= values.get(index);
            index++;
        }

        return new Tuple(totalSum, cumulativeProduct);
    }

    // Inner class to represent a tuple
    public static class Tuple {
        private final int sum;
        private final int product;

        public Tuple(int sum, int product) {
            this.sum = sum;
            this.product = product;
        }

        public int getSum() {
            return sum;
        }

        public int getProduct() {
            return product;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Tuple tuple = (Tuple) o;

            if (sum != tuple.sum) return false;
            return product == tuple.product;
        }

        @Override
        public int hashCode() {
            int result = sum;
            result = 31 * result + product;
            return result;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {List.of(), new Tuple(0, 1)},
        {List.of(1), new Tuple(1, 1)},
        {List.of(2, 3), new Tuple(5, 6)},
        {List.of(4, 5, 6), new Tuple(15, 120)},
        {List.of(7, 8, 9, 10), new Tuple(34, 5040)},
        {List.of(0, 1, 2, 3), new Tuple(6, 0)},
        {List.of(1, -1, 1, -1), new Tuple(0, 1)},
        {List.of(10, 20, 30), new Tuple(60, 6000)},
        {List.of(5, 5, 5, 5), new Tuple(20, 625)},
        {List.of(1, 2, 3, 4, 5), new Tuple(15, 120)}
    };

    @Test
    public void test_0() {
        assertEquals(testCases[0][1], sumProduct((List<Integer>) testCases[0][0]));
        assertEquals(testCases[0][1], calculateAggregates((List<Integer>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(testCases[1][1], sumProduct((List<Integer>) testCases[1][0]));
        assertEquals(testCases[1][1], calculateAggregates((List<Integer>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(testCases[2][1], sumProduct((List<Integer>) testCases[2][0]));
        assertEquals(testCases[2][1], calculateAggregates((List<Integer>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(testCases[3][1], sumProduct((List<Integer>) testCases[3][0]));
        assertEquals(testCases[3][1], calculateAggregates((List<Integer>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(testCases[4][1], sumProduct((List<Integer>) testCases[4][0]));
        assertEquals(testCases[4][1], calculateAggregates((List<Integer>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(testCases[5][1], sumProduct((List<Integer>) testCases[5][0]));
        assertEquals(testCases[5][1], calculateAggregates((List<Integer>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(testCases[6][1], sumProduct((List<Integer>) testCases[6][0]));
        assertEquals(testCases[6][1], calculateAggregates((List<Integer>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(testCases[7][1], sumProduct((List<Integer>) testCases[7][0]));
        assertEquals(testCases[7][1], calculateAggregates((List<Integer>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(testCases[8][1], sumProduct((List<Integer>) testCases[8][0]));
        assertEquals(testCases[8][1], calculateAggregates((List<Integer>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(testCases[9][1], sumProduct((List<Integer>) testCases[9][0]));
        assertEquals(testCases[9][1], calculateAggregates((List<Integer>) testCases[9][0]));
    }
}