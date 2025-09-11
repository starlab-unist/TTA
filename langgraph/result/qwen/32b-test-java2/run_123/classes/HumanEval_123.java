import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_123 {

    // Source Code
    static class HumanEval_123_Source {
        public List<Integer> getOddCollatz(int n) {
            List<Integer> oddCollatz;
            if (n % 2 == 0) {
                oddCollatz = new ArrayList<>();
            } else {
                oddCollatz = new ArrayList<>();
                oddCollatz.add(n);
            }
            while (n > 1) {
                if (n % 2 == 0) {
                    n = n / 2;
                } else {
                    n = n * 3 + 1;
                }

                if (n % 2 == 1) {
                    oddCollatz.add(n);
                }
            }

            Collections.sort(oddCollatz);
            return oddCollatz;
        }
    }

    // Transformed Code
    static class HumanEval_123_Transformed {
        public List<Integer> extractOddNumbersInSequence(int startingValue) {
            List<Integer> sequenceOfOdds = new ArrayList<>();
            
            if (startingValue % 2 != 0) {
                sequenceOfOdds.add(startingValue);
            }

            int currentValue = startingValue;
            while (currentValue > 1) {
                if (currentValue % 2 == 0) {
                    currentValue /= 2;
                } else {
                    currentValue = currentValue * 3 + 1;
                }

                if (currentValue % 2 != 0) {
                    sequenceOfOdds.add(currentValue);
                }
            }

            Collections.sort(sequenceOfOdds);
            return sequenceOfOdds;
        }
    }

    // Test Cases
    private static final int[] testCases = {
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10
    };

    @Test
    public void test_0() {
        assertEquals(new HumanEval_123_Source().getOddCollatz(testCases[0]), 
                     new HumanEval_123_Transformed().extractOddNumbersInSequence(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_123_Source().getOddCollatz(testCases[1]), 
                     new HumanEval_123_Transformed().extractOddNumbersInSequence(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_123_Source().getOddCollatz(testCases[2]), 
                     new HumanEval_123_Transformed().extractOddNumbersInSequence(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_123_Source().getOddCollatz(testCases[3]), 
                     new HumanEval_123_Transformed().extractOddNumbersInSequence(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_123_Source().getOddCollatz(testCases[4]), 
                     new HumanEval_123_Transformed().extractOddNumbersInSequence(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_123_Source().getOddCollatz(testCases[5]), 
                     new HumanEval_123_Transformed().extractOddNumbersInSequence(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_123_Source().getOddCollatz(testCases[6]), 
                     new HumanEval_123_Transformed().extractOddNumbersInSequence(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_123_Source().getOddCollatz(testCases[7]), 
                     new HumanEval_123_Transformed().extractOddNumbersInSequence(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_123_Source().getOddCollatz(testCases[8]), 
                     new HumanEval_123_Transformed().extractOddNumbersInSequence(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_123_Source().getOddCollatz(testCases[9]), 
                     new HumanEval_123_Transformed().extractOddNumbersInSequence(testCases[9]));
    }
}