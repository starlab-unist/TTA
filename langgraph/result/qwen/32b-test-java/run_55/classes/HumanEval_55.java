import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HumanEval_55 {

    // Source Code Method
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // Transformed Code Method
    public int calculateFibonacci(int sequenceIndex) {
        if (sequenceIndex == 0) {
            return 0;
        } else if (sequenceIndex == 1) {
            return 1;
        }

        int previous = 0, current = 1;
        int index = 2;
        while (index <= sequenceIndex) {
            int next = previous + current;
            previous = current;
            current = next;
            index++;
        }

        return current;
    }

    // Test Cases
    @ParameterizedTest(name = "Fibonacci Test with input: {0}")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 10, 15, 20, 25})
    public void testFibonacciEquivalence(int n) {
        assertEquals(fib(n), calculateFibonacci(n));
    }
}