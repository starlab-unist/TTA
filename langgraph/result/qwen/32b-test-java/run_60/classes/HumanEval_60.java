import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_60 {

    // Source Code
    static class HumanEval_60 {
        public static int sumToN(int n) {
            int sum = 0;
            for (int i = 0; i <= n; i++) {
                sum += i;
            }
            return sum;
        }
    }

    // Transformed Code
    static class HumanEval_60_Transformed {
        public int calculateTotalUpTo(int number) {
            int totalSum = 0;
            int current = 0;
            
            while (current <= number) {
                totalSum += current;
                current += 1;
            }
            
            return totalSum;
        }
    }

    // Test cases
    private static final int[] testCases = {
        0,      // Edge case: smallest possible input
        1,      // Simple case
        2,      // Another simple case
        5,      // Small positive integer
        10,     // Medium positive integer
        20,     // Larger positive integer
        50,     // Another larger positive integer
        100,    // Large positive integer
        -1,     // Negative number (edge case)
        -5,     // Another negative number
        1000,   // Very large positive integer
        2000,   // Another very large positive integer
        1       // Repeated simple case
    };

    @Test
    public void testSumToN_vs_CalculateTotalUpTo() {
        HumanEval_60_Transformed transformedCode = new HumanEval_60_Transformed();
        
        for (int i = 0; i < testCases.length; i++) {
            assertEquals(
                HumanEval_60.sumToN(testCases[i]),
                transformedCode.calculateTotalUpTo(testCases[i]),
                "Test case index: " + i + ", Input value: " + testCases[i]
            );
        }
    }
}