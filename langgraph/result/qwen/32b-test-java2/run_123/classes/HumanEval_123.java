import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;

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

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).boxed().map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void getOddCollatz_vs_extractOddNumbersInSequence(int input) {
        HumanEval_123_Source source = new HumanEval_123_Source();
        HumanEval_123_Transformed transformed = new HumanEval_123_Transformed();

        assertEquals(
            source.getOddCollatz(input),
            transformed.extractOddNumbersInSequence(input)
        );
    }
}