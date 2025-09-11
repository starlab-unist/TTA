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
    static class HumanEval_100_Source {
        public List<Integer> makeAPile(int n) {
            List<Integer> pile = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                pile.add(n + 2 * i);
            }
            return pile;
        }
    }

    // Transformed Code
    static class HumanEval_100_Transformed {
        public List<Integer> makeAPile(int n) {
            List<Integer> pile = new ArrayList<>();
            int index = 0;
            while (index < n) {
                pile.add(n + 2 * index);
                index += 1;
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
        assertEquals(new HumanEval_100_Source().makeAPile(testCases[0]), new HumanEval_100_Transformed().makeAPile(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_100_Source().makeAPile(testCases[1]), new HumanEval_100_Transformed().makeAPile(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_100_Source().makeAPile(testCases[2]), new HumanEval_100_Transformed().makeAPile(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_100_Source().makeAPile(testCases[3]), new HumanEval_100_Transformed().makeAPile(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_100_Source().makeAPile(testCases[4]), new HumanEval_100_Transformed().makeAPile(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_100_Source().makeAPile(testCases[5]), new HumanEval_100_Transformed().makeAPile(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_100_Source().makeAPile(testCases[6]), new HumanEval_100_Transformed().makeAPile(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_100_Source().makeAPile(testCases[7]), new HumanEval_100_Transformed().makeAPile(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_100_Source().makeAPile(testCases[8]), new HumanEval_100_Transformed().makeAPile(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_100_Source().makeAPile(testCases[9]), new HumanEval_100_Transformed().makeAPile(testCases[9]));
    }
}