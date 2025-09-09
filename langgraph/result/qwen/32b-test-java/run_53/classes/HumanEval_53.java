import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_53 {

    // Source Code
    static class SourceCode {
        public int add(int x, int y) {
            return x + y;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public int computeSum(int a, int b) {
            int total = a + b;
            return total;
        }
    }

    // Test Cases
    @ParameterizedTest(name = "{index} => x={0}, y={1}")
    @CsvSource({
        "1, 2",
        "-1, -1",
        "0, 0",
        "100, 200",
        "-50, 50",
        "123456789, 987654321",
        "0, 1",
        "10, -10",
        "999, 1",
        "1, 999"
    })
    void add_vs_computeSum(int x, int y) {
        assertEquals(
            new SourceCode().add(x, y),
            new TransformedCode().computeSum(x, y)
        );
    }
}