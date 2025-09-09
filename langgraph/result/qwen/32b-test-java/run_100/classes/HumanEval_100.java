import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_100 {

    // Source Code
    static class SourceCode {
        public List<Integer> makeAPile(int n) {
            List<Integer> pile = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                pile.add(n + 2 * i);
            }
            return pile;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public List<Integer> constructStack(int size) {
            List<Integer> pile = new ArrayList<>();
            int index = 0;
            while (index < size) {
                pile.add(size + 2 * index);
                index++;
            }
            return pile;
        }
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
        assertEquals(new SourceCode().makeAPile(testCases[0]), new TransformedCode().constructStack(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(new SourceCode().makeAPile(testCases[1]), new TransformedCode().constructStack(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(new SourceCode().makeAPile(testCases[2]), new TransformedCode().constructStack(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(new SourceCode().makeAPile(testCases[3]), new TransformedCode().constructStack(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(new SourceCode().makeAPile(testCases[4]), new TransformedCode().constructStack(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(new SourceCode().makeAPile(testCases[5]), new TransformedCode().constructStack(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(new SourceCode().makeAPile(testCases[6]), new TransformedCode().constructStack(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(new SourceCode().makeAPile(testCases[7]), new TransformedCode().constructStack(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(new SourceCode().makeAPile(testCases[8]), new TransformedCode().constructStack(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(new SourceCode().makeAPile(testCases[9]), new TransformedCode().constructStack(testCases[9]));
    }
}