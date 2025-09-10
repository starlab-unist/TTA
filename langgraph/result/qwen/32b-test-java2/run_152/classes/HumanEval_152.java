import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_152 {

    // Source Code
    static class HumanEval_152_Source {
        public List<Integer> compare(List<Integer> game, List<Integer> guess) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < game.size(); i++) {
                result.add(Math.abs(game.get(i) - guess.get(i)));
            }
            return result;
        }
    }

    // Transformed Code
    static class HumanEval_152_Transformed {
        public List<Integer> evaluateDifference(List<Integer> actual, List<Integer> playerGuess) {
            List<Integer> differences = new ArrayList<>();
            int index = 0;
            while (index < actual.size()) {
                differences.add(Math.abs(actual.get(index) - playerGuess.get(index)));
                index++;
            }
            return differences;
        }
    }

    // Test Cases
    private static final Arguments[] testCases = {
        Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3)),
        Arguments.of(Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9)),
        Arguments.of(Arrays.asList(0, 0, 0), Arrays.asList(1, 1, 1)),
        Arguments.of(Arrays.asList(-1, -2, -3), Arrays.asList(-1, -2, -3)),
        Arguments.of(Arrays.asList(10, 20, 30), Arrays.asList(30, 20, 10)),
        Arguments.of(Arrays.asList(100, 200, 300), Arrays.asList(150, 250, 350)),
        Arguments.of(Arrays.asList(1, 1, 1, 1, 1), Arrays.asList(1, 1, 1, 1, 1)),
        Arguments.of(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(5, 4, 3, 2, 1)),
        Arguments.of(Arrays.asList(0, 1, 2, 3, 4), Arrays.asList(4, 3, 2, 1, 0)),
        Arguments.of(Arrays.asList(-5, -10, -15), Arrays.asList(-15, -10, -5))
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void compare_vs_evaluateDifference(List<Integer> game, List<Integer> guess) {
        HumanEval_152_Source sourceInstance = new HumanEval_152_Source();
        HumanEval_152_Transformed transformedInstance = new HumanEval_152_Transformed();

        assertEquals(
            sourceInstance.compare(game, guess),
            transformedInstance.evaluateDifference(game, guess)
        );
    }
}