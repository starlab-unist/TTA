import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_106 {

    // Source Code
    static class SourceCode {
        public List<Integer> f(int n) {
            List<Integer> ret = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0) {
                    int x = 1;
                    for (int j = 1; j <= i; j++) {
                        x *= j;
                    }
                    ret.add(x);
                } else {
                    int x = 0;
                    for (int j = 1; j <= i; j++) {
                        x += j;
                    }
                    ret.add(x);
                }
            }
            return ret;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public List<Integer> generate_alternating_sequence(int limit) {
            List<Integer> result = new ArrayList<>();
            int index = 1;
            while (index <= limit) {
                if (index % 2 == 0) {
                    int factorial = 1;
                    int inner_index = 1;
                    while (inner_index <= index) {
                        factorial *= inner_index;
                        inner_index++;
                    }
                    result.add(factorial);
                } else {
                    int summation = 0;
                    int inner_index = 1;
                    while (inner_index <= index) {
                        summation += inner_index;
                        inner_index++;
                    }
                    result.add(summation);
                }
                index++;
            }
            return result;
        }
    }

    // Test Cases
    private static final Integer[] testCases = {
        0,  // Edge case: no elements
        1,  // Only one element, odd
        2,  // Two elements, odd then even
        3,  // Three elements, odd, even, odd
        4,  // Four elements, odd, even, odd, even
        5,  // Five elements, odd, even, odd, even, odd
        10, // Ten elements
        20, // Twenty elements
        30, // Thirty elements
        50  // Fifty elements
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest(name = "f({0}) == generate_alternating_sequence({0})")
    @MethodSource("provideTestCases")
    void f_vs_generate_alternating_sequence(int input) {
        SourceCode sourceCodeInstance = new SourceCode();
        TransformedCode transformedCodeInstance = new TransformedCode();

        assertEquals(
            sourceCodeInstance.f(input),
            transformedCodeInstance.generate_alternating_sequence(input)
        );
    }
}