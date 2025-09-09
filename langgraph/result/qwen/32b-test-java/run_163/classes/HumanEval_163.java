import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_163 {

    // Source Code
    static class SourceCode {
        public List<Integer> generateIntegers(int a, int b) {
            int lower = Math.max(2, Math.min(a, b));
            int upper = Math.min(8, Math.max(a, b));

            List<Integer> result = new ArrayList<>();
            for (int i = lower; i <= upper; i++) {
                if (i % 2 == 0) {
                    result.add(i);
                }
            }
            return result;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public List<Integer> produceEvenNumbers(int x, int y) {
            int start = Math.max(2, Math.min(x, y));
            int end = Math.min(8, Math.max(x, y));

            List<Integer> evenNumbers = new ArrayList<>();
            int current = start;
            while (current <= end) {
                if (current % 2 == 0) {
                    evenNumbers.add(current);
                }
                current++;
            }

            return evenNumbers;
        }
    }

    // Test Cases
    @ParameterizedTest(name = "Test case {index} with input ({arguments})")
    @CsvSource({
        "1, 5",
        "3, 9",
        "6, 2",
        "8, 8",
        "0, 4",
        "7, 7",
        "2, 2",
        "10, 1",
        "5, 5",
        "4, 4"
    })
    void generateIntegers_vs_produceEvenNumbers(int a, int b) {
        assertEquals(
            new SourceCode().generateIntegers(a, b),
            new TransformedCode().produceEvenNumbers(a, b)
        );
    }
}