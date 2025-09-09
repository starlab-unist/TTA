import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_30 {

    // Source Code Class
    static class SourceCode {
        public List<Integer> getPositive(List<Integer> l) {
            List<Integer> result = new ArrayList<>();
            for (Integer e : l) {
                if (e > 0) {
                    result.add(e);
                }
            }
            return result;
        }
    }

    // Transformed Code Class
    static class TransformedCode {
        public List<Integer> extractPositiveNumbers(List<Integer> inputList) {
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
        {new ArrayList<Integer>()},
        {Arrays.asList(-10, 0, 10)},
        {Arrays.asList(5)},
        {Arrays.asList(-5)},
        {Arrays.asList(1, 2, 3, 4, 5, -6, -7, -8, -9, -10)},
        {Arrays.asList(100, 200, 300, -100, -200, -300)}
    };

    @Test
    public void test_0() {
        assertEquals(new SourceCode().getPositive(testCases[0][0]), new TransformedCode().extractPositiveNumbers(testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(new SourceCode().getPositive(testCases[1][0]), new TransformedCode().extractPositiveNumbers(testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(new SourceCode().getPositive(testCases[2][0]), new TransformedCode().extractPositiveNumbers(testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(new SourceCode().getPositive(testCases[3][0]), new TransformedCode().extractPositiveNumbers(testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(new SourceCode().getPositive(testCases[4][0]), new TransformedCode().extractPositiveNumbers(testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(new SourceCode().getPositive(testCases[5][0]), new TransformedCode().extractPositiveNumbers(testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(new SourceCode().getPositive(testCases[6][0]), new TransformedCode().extractPositiveNumbers(testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(new SourceCode().getPositive(testCases[7][0]), new TransformedCode().extractPositiveNumbers(testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(new SourceCode().getPositive(testCases[8][0]), new TransformedCode().extractPositiveNumbers(testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(new SourceCode().getPositive(testCases[9][0]), new TransformedCode().extractPositiveNumbers(testCases[9][0]));
    }
}