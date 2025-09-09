import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_106 {

    // Source Code
    static class HumanEval_106_Source {
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
    static class HumanEval_106_Transformed {
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
    @ParameterizedTest(name = "Test case {index} with input value: {0}")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void test_f_vs_generate_alternating_sequence(int n) {
        HumanEval_106_Source sourceCode = new HumanEval_106_Source();
        HumanEval_106_Transformed transformedCode = new HumanEval_106_Transformed();

        assertEquals(
            sourceCode.f(n),
            transformedCode.generate_alternating_sequence(n)
        );
    }
}