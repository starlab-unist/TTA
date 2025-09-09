import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_123 {

    // Source Code Implementation
    static class SourceCode {
        public List<Integer> getOddCollatz(int n) {
            List<Integer> oddCollatz = new ArrayList<>();
            if (n % 2 != 0) {
                oddCollatz.add(n);
            }
            while (n > 1) {
                if (n % 2 == 0) {
                    n = n / 2;
                } else {
                    n = n * 3 + 1;
                }

                if (n % 2 != 0) {
                    oddCollatz.add(n);
                }
            }

            Collections.sort(oddCollatz);
            return oddCollatz;
        }
    }

    // Transformed Code Implementation
    static class TransformedCode {
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
    @ParameterizedTest(name = "test case {index}")
    @DisplayName("Comparing getOddCollatz with extractOddNumbersInSequence")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 15, 16, 17, 20, 25, 30, 35, 40, 45})
    void getOddCollatz_vs_extractOddNumbersInSequence(int input) {
        assertEquals(
            new SourceCode().getOddCollatz(input),
            new TransformedCode().extractOddNumbersInSequence(input),
            "Input: " + input
        );
    }
}