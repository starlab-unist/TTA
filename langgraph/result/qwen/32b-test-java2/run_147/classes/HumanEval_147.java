import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_147 {

    // Source Code
    static class HumanEval_147_Source {
        private static final HumanEval_147_Source INSTANCE = new HumanEval_147_Source();
        
        private HumanEval_147_Source() {}
        
        public static HumanEval_147_Source getInstance() {
            return INSTANCE;
        }
        
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
        private static final HumanEval_147_Transformed INSTANCE = new HumanEval_147_Transformed();
        
        private HumanEval_147_Transformed() {}
        
        public static HumanEval_147_Transformed getInstance() {
            return INSTANCE;
        }
        
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
    private static final Integer[] testCases = {
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

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void getMaxTriples_vs_countDivisibleTriples(int input) {
        assertEquals(
            HumanEval_147_Source.getInstance().getMaxTriples(input),
            HumanEval_147_Transformed.getInstance().countDivisibleTriples(input)
        );
    }
}