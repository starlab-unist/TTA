import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    public void getMaxTriples_vs_countDivisibleTriples(int n) {
        HumanEval_147_Source sourceCode = new HumanEval_147_Source();
        HumanEval_147_Transformed transformedCode = new HumanEval_147_Transformed();

        assertEquals(
            sourceCode.getMaxTriples(n),
            transformedCode.countDivisibleTriples(n)
        );
    }
}