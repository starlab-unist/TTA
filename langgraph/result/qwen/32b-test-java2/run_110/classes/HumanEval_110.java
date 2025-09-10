import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_110 {

    // Source Code
    static class SourceCode {
        public static String exchange(int[] lst1, int[] lst2) {
            int odd = 0;
            int even = 0;
            for (int i : lst1) {
                if (i % 2 == 1) {
                    odd += 1;
                }
            }
            for (int i : lst2) {
                if (i % 2 == 0) {
                    even += 1;
                }
            }
            if (even >= odd) {
                return "YES";
            }
            return "NO";
        }
    }

    // Transformed Code
    static class TransformedCode {
        public String compareParity(int[] listA, int[] listB) {
            int oddCount = 0;
            int evenCount = 0;
            int index = 0;

            while (index < listA.length) {
                if (listA[index] % 2 != 0) {
                    oddCount += 1;
                }
                index += 1;
            }

            index = 0;
            while (index < listB.length) {
                if (listB[index] % 2 == 0) {
                    evenCount += 1;
                }
                index += 1;
            }

            return evenCount >= oddCount ? "YES" : "NO";
        }
    }

    // Test Cases
    private static final int[][][] testCases = {
        { {1, 3, 5}, {2, 4, 6} },    // odd: 3, even: 3 -> YES
        { {1, 2, 3}, {4, 5, 6} },    // odd: 2, even: 2 -> YES
        { {1, 1, 1}, {2, 4, 6} },    // odd: 3, even: 3 -> YES
        { {1, 3, 5}, {1, 3, 5} },    // odd: 3, even: 0 -> NO
        { {2, 4, 6}, {1, 3, 5} },    // odd: 0, even: 3 -> YES
        { {}, {} },                  // odd: 0, even: 0 -> YES
        { {1}, {2} },                // odd: 1, even: 1 -> YES
        { {1, 3, 5, 7}, {2} },       // odd: 4, even: 1 -> NO
        { {2, 4, 6, 8}, {1, 3, 5} }, // odd: 3, even: 4 -> YES
        { {}, {1, 3, 5} }            // odd: 0, even: 0 -> YES (since even >= odd)
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void exchange_vs_compareParity(int[] lst1, int[] lst2) {
        TransformedCode transformedCode = new TransformedCode();
        assertEquals(
            SourceCode.exchange(lst1, lst2),
            transformedCode.compareParity(lst1, lst2)
        );
    }
}