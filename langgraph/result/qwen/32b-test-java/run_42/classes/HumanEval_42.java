import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_42 {

    // Source Code
    static class SourceCode {
        public static List<Integer> incrList(List<Integer> l) {
            List<Integer> result = new ArrayList<>();
            for (Integer e : l) {
                result.add(e + 1);
            }
            return result;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public List<Integer> incrementElements(List<Integer> inputList) {
            List<Integer> result = new ArrayList<>();
            int index = 0;
            while (index < inputList.size()) {
                result.add(inputList.get(index) + 1);
                index++;
            }
            return result;
        }
    }

    // Test Cases
    private static final Integer[][] testCases = {
        {1, 2, 3, 4, 5},
        {-1, -2, -3, -4, -5},
        {0, 0, 0, 0},
        {},
        {100, 200, 300},
        {-100, 0, 100},
        {1},
        {-1},
        {0},
        {9, 8, 7, 6, 5}
    };

    @Test
    public void test_0() {
        assertEquals(SourceCode.incrList(Arrays.asList(testCases[0])), new TransformedCode().incrementElements(Arrays.asList(testCases[0])));
    }

    @Test
    public void test_1() {
        assertEquals(SourceCode.incrList(Arrays.asList(testCases[1])), new TransformedCode().incrementElements(Arrays.asList(testCases[1])));
    }

    @Test
    public void test_2() {
        assertEquals(SourceCode.incrList(Arrays.asList(testCases[2])), new TransformedCode().incrementElements(Arrays.asList(testCases[2])));
    }

    @Test
    public void test_3() {
        assertEquals(SourceCode.incrList(Arrays.asList(testCases[3])), new TransformedCode().incrementElements(Arrays.asList(testCases[3])));
    }

    @Test
    public void test_4() {
        assertEquals(SourceCode.incrList(Arrays.asList(testCases[4])), new TransformedCode().incrementElements(Arrays.asList(testCases[4])));
    }

    @Test
    public void test_5() {
        assertEquals(SourceCode.incrList(Arrays.asList(testCases[5])), new TransformedCode().incrementElements(Arrays.asList(testCases[5])));
    }

    @Test
    public void test_6() {
        assertEquals(SourceCode.incrList(Arrays.asList(testCases[6])), new TransformedCode().incrementElements(Arrays.asList(testCases[6])));
    }

    @Test
    public void test_7() {
        assertEquals(SourceCode.incrList(Arrays.asList(testCases[7])), new TransformedCode().incrementElements(Arrays.asList(testCases[7])));
    }

    @Test
    public void test_8() {
        assertEquals(SourceCode.incrList(Arrays.asList(testCases[8])), new TransformedCode().incrementElements(Arrays.asList(testCases[8])));
    }

    @Test
    public void test_9() {
        assertEquals(SourceCode.incrList(Arrays.asList(testCases[9])), new TransformedCode().incrementElements(Arrays.asList(testCases[9])));
    }
}