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

public class HumanEval_30 {

    // Source Code
    static class HumanEval_30_Source {
        public static List<Integer> getPositive(List<Integer> l) {
            return l.stream().filter(e -> e > 0).collect(Collectors.toList());
        }
    }

    // Transformed Code
    static class HumanEval_30_Transformed {
        public static List<Integer> extractPositiveNumbers(List<Integer> inputList) {
            List<Integer> positiveNumbers = new ArrayList<>();
            int index = 0;

            while (index < inputList.size()) {
                if (inputList.get(index) > 0) {
                    positiveNumbers.add(inputList.get(index));
                }
                index++;
            }

            return positiveNumbers;
        }
    }

    // Test Cases
    private static final List<Integer>[][] testCases = {
        {Arrays.asList(1, -2, 3, 4, -5)},
        {Arrays.asList(-1, -2, -3, -4, -5)},
        {Arrays.asList(0, 0, 0, 0)},
        {Arrays.asList(10, 20, 30, 40, 50)},
        {Arrays.asList()},
        {Arrays.asList(-10, 0, 10)},
        {Arrays.asList(5)},
        {Arrays.asList(-5)},
        {Arrays.asList(1, 2, 3, 4, 5, -6, -7, -8, -9, -10)},
        {Arrays.asList(100, 200, 300, -100, -200, -300)}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_30_Source.getPositive(testCases[0][0]), HumanEval_30_Transformed.extractPositiveNumbers(testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_30_Source.getPositive(testCases[1][0]), HumanEval_30_Transformed.extractPositiveNumbers(testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_30_Source.getPositive(testCases[2][0]), HumanEval_30_Transformed.extractPositiveNumbers(testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_30_Source.getPositive(testCases[3][0]), HumanEval_30_Transformed.extractPositiveNumbers(testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_30_Source.getPositive(testCases[4][0]), HumanEval_30_Transformed.extractPositiveNumbers(testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_30_Source.getPositive(testCases[5][0]), HumanEval_30_Transformed.extractPositiveNumbers(testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_30_Source.getPositive(testCases[6][0]), HumanEval_30_Transformed.extractPositiveNumbers(testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_30_Source.getPositive(testCases[7][0]), HumanEval_30_Transformed.extractPositiveNumbers(testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_30_Source.getPositive(testCases[8][0]), HumanEval_30_Transformed.extractPositiveNumbers(testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_30_Source.getPositive(testCases[9][0]), HumanEval_30_Transformed.extractPositiveNumbers(testCases[9][0]));
    }
}