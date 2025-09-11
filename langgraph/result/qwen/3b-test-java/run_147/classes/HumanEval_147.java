import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_147 {

    // Source Code
    static class HumanEval_147_Source {
        public static int getMaxTriples(int n) {
            int[] A = new int[n];
            for (int i = 1; i <= n; i++) {
                A[i - 1] = i * i - i + 1;
            }
            
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if ((A[i] + A[j] + A[k]) % 3 == 0) {
                            count++;
                        }
                    }
                }
            }
            
            return count;
        }

        public static void main(String[] args) {
            System.out.println(getMaxTriples(5)); // Example usage
        }
    }

    // Transformed Code
    static class HumanEval_147_Transformed {
        public static int countDivisibleTriples(int limit) {
            int[] sequence = new int[limit];
            for (int i = 1; i <= limit; i++) {
                sequence[i - 1] = i * i - i + 1;
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
    private static final int[] testCases = {
        1,  // No triples possible
        2,  // No triples possible
        3,  // One triple (1, 3, 7)
        4,  // Two triples (1, 7, 19), (3, 7, 13)
        5,  // Four triples (1, 7, 31), (1, 13, 21), (3, 7, 31), (3, 13, 19)
        6,  // Six triples
        7,  // Ten triples
        8,  // Fourteen triples
        9,  // Twenty-one triples
        10  // Thirty-one triples
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_147_Source.getMaxTriples(testCases[0]), HumanEval_147_Transformed.countDivisibleTriples(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_147_Source.getMaxTriples(testCases[1]), HumanEval_147_Transformed.countDivisibleTriples(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_147_Source.getMaxTriples(testCases[2]), HumanEval_147_Transformed.countDivisibleTriples(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_147_Source.getMaxTriples(testCases[3]), HumanEval_147_Transformed.countDivisibleTriples(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_147_Source.getMaxTriples(testCases[4]), HumanEval_147_Transformed.countDivisibleTriples(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_147_Source.getMaxTriples(testCases[5]), HumanEval_147_Transformed.countDivisibleTriples(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_147_Source.getMaxTriples(testCases[6]), HumanEval_147_Transformed.countDivisibleTriples(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_147_Source.getMaxTriples(testCases[7]), HumanEval_147_Transformed.countDivisibleTriples(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_147_Source.getMaxTriples(testCases[8]), HumanEval_147_Transformed.countDivisibleTriples(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_147_Source.getMaxTriples(testCases[9]), HumanEval_147_Transformed.countDivisibleTriples(testCases[9]));
    }
}