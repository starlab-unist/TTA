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

public class HumanEval_147 {

    // Source Code
    static class HumanEval_147_Source {
        public int getMaxTriples(int n) {
            List<Integer> A = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                A.add(i * i - i + 1);
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if ((A.get(i) + A.get(j) + A.get(k)) % 3 == 0) {
                            count++;
                        }
                    }
                }
            }
            return count;
        }
    }

    // Transformed Code
    static class HumanEval_147_Transformed {
        public int countDivisibleTriples(int limit) {
            int[] sequence = new int[limit];
            for (int x = 1; x <= limit; x++) {
                sequence[x - 1] = x * x - x + 1;
            }
            int resultCount = 0;

            int indexI = 0;
            while (indexI < limit) {
                int indexJ = indexI + 1;
                while (indexJ < limit) {
                    int indexK = indexJ + 1;
                    while (indexK < limit) {
                        if ((sequence[indexI] + sequence[indexJ] + sequence[indexK]) % 3 == 0) {
                            resultCount++;
                        }
                        indexK++;
                    }
                    indexJ++;
                }
                indexI++;
            }

            return resultCount;
        }
    }

    // Test Cases
    private static final int[] testCases = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void test_0() {
        assertEquals(new HumanEval_147_Source().getMaxTriples(testCases[0]), 
                     new HumanEval_147_Transformed().countDivisibleTriples(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_147_Source().getMaxTriples(testCases[1]), 
                     new HumanEval_147_Transformed().countDivisibleTriples(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_147_Source().getMaxTriples(testCases[2]), 
                     new HumanEval_147_Transformed().countDivisibleTriples(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_147_Source().getMaxTriples(testCases[3]), 
                     new HumanEval_147_Transformed().countDivisibleTriples(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_147_Source().getMaxTriples(testCases[4]), 
                     new HumanEval_147_Transformed().countDivisibleTriples(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_147_Source().getMaxTriples(testCases[5]), 
                     new HumanEval_147_Transformed().countDivisibleTriples(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_147_Source().getMaxTriples(testCases[6]), 
                     new HumanEval_147_Transformed().countDivisibleTriples(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_147_Source().getMaxTriples(testCases[7]), 
                     new HumanEval_147_Transformed().countDivisibleTriples(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_147_Source().getMaxTriples(testCases[8]), 
                     new HumanEval_147_Transformed().countDivisibleTriples(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_147_Source().getMaxTriples(testCases[9]), 
                     new HumanEval_147_Transformed().countDivisibleTriples(testCases[9]));
    }
}