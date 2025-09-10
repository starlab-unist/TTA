import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_100 {

    // Source Code
    static class SourceCode {
        public List<Integer> makeAPile(int n) {
            List<Integer> pile = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                pile.add(n + 2 * i);
            }
            return pile;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public List<Integer> constructStack(int size) {
            List<Integer> pile = new ArrayList<>();
            int index = 0;
            while (index < size) {
                pile.add(size + 2 * index);
                index++;
            }
            return pile;
        }
    }

    // Test Cases
    @ParameterizedTest(name = "Test case {index} with input value: {arguments}")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 10, 15, 20, 25})
    void makeAPile_vs_constructStack(int n) {
        SourceCode source = new SourceCode();
        TransformedCode transformed = new TransformedCode();
        
        assertEquals(
            source.makeAPile(n),
            transformed.constructStack(n)
        );
    }
}