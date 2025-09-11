import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_15 {

    // Source Code
    static class HumanEval_15_Source {
        public String stringSequence(int n) {
            StringBuilder result = new StringBuilder();
            for (int x = 0; x <= n; x++) {
                result.append(x);
                if (x < n) {
                    result.append(" ");
                }
            }
            return result.toString();
        }
    }

    // Transformed Code
    static class HumanEval_15_Transformed {
        public String generateNumberSeries(int length) {
            StringBuilder numberList = new StringBuilder();
            int index = 0;

            while (index <= length) {
                numberList.append(index);
                if (index < length) {
                    numberList.append(" ");
                }
                index++;
            }

            return numberList.toString();
        }
    }

    // Test Cases
    private static final int[] testCases = {
        0,
        1,
        5,
        10,
        20,
        100,
        -1,  // Edge case: negative input
        3,
        7,
        15
    };

    @Test
    public void test_0() {
        assertEquals(new HumanEval_15_Source().stringSequence(testCases[0]), 
                     new HumanEval_15_Transformed().generateNumberSeries(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_15_Source().stringSequence(testCases[1]), 
                     new HumanEval_15_Transformed().generateNumberSeries(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_15_Source().stringSequence(testCases[2]), 
                     new HumanEval_15_Transformed().generateNumberSeries(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_15_Source().stringSequence(testCases[3]), 
                     new HumanEval_15_Transformed().generateNumberSeries(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_15_Source().stringSequence(testCases[4]), 
                     new HumanEval_15_Transformed().generateNumberSeries(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_15_Source().stringSequence(testCases[5]), 
                     new HumanEval_15_Transformed().generateNumberSeries(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_15_Source().stringSequence(testCases[6]), 
                     new HumanEval_15_Transformed().generateNumberSeries(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_15_Source().stringSequence(testCases[7]), 
                     new HumanEval_15_Transformed().generateNumberSeries(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_15_Source().stringSequence(testCases[8]), 
                     new HumanEval_15_Transformed().generateNumberSeries(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_15_Source().stringSequence(testCases[9]), 
                     new HumanEval_15_Transformed().generateNumberSeries(testCases[9]));
    }
}