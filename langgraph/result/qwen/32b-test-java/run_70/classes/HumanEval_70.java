import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Source Code
class HumanEval_70_Source {
    public static List<Integer> strangeSortList(List<Integer> lst) {
        List<Integer> res = new ArrayList<>();
        boolean switcher = true;
        while (!lst.isEmpty()) {
            int value = switcher ? Collections.min(lst) : Collections.max(lst);
            res.add(value);
            lst.remove(Integer.valueOf(value));
            switcher = !switcher;
        }
        return res;
    }
}

// Transformed Code
class HumanEval_70_Transformed {
    public List<Integer> alternateSortSequence(List<Integer> sequence) {
        List<Integer> result = new ArrayList<>();
        boolean toggle = true;
        while (!sequence.isEmpty()) {
            int selectedValue = toggle ? Collections.min(sequence) : Collections.max(sequence);
            result.add(selectedValue);
            sequence.remove(Integer.valueOf(selectedValue));
            toggle = !toggle;
        }
        return result;
    }
}

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_70 {

    // Test Cases
    private static final List<Integer>[][] testCases = {
        {List.of(3, 1, 2)},
        {List.of(9, 7, 5, 3, 1)},
        {List.of(10, 20, 30, 40, 50)},
        {List.of(5, 5, 5, 5)},
        {List.of(1)},
        {List.of()},
        {List.of(8, 6, 7, 5, 3, 0, 9)},
        {List.of(2, 2, 2, 1, 1, 1, 3, 3, 3)},
        {List.of(-1, -2, -3, -4, -5)},
        {List.of(100, 200, 150, 50, 250)},
        // Additional test cases
        {List.of(-10, -20, -30, -40, -50)}, // Negative numbers in descending order
        {List.of(0, 0, 0, 0, 0)}, // All zeros
        {List.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)}, // Descending order
        {List.of(-5, 5, -10, 10, 0)}, // Mixed positive and negative numbers with zero
        {List.of(100)} // Single element
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Testing equivalence of strangeSortList and alternateSortSequence")
    void strangeSortList_vs_alternateSortSequence(List<Integer> input) {
        assertEquals(
            HumanEval_70_Source.strangeSortList(new ArrayList<>(input)),
            new HumanEval_70_Transformed().alternateSortSequence(new ArrayList<>(input))
        );
    }
}