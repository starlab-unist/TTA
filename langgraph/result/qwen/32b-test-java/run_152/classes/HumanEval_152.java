import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_152 {

    // Source Code
    static class SourceCode {
        public List<Integer> compare(List<Integer> game, List<Integer> guess) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < game.size(); i++) {
                result.add(Math.abs(game.get(i) - guess.get(i)));
            }
            return result;
        }
    }

    // Transformed Code
    static class TransformedCode {
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
    private static final Object[][] testCases = {
        {Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3)},
        {Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9)},
        {Arrays.asList(0, 0, 0), Arrays.asList(1, 1, 1)},
        {Arrays.asList(-1, -2, -3), Arrays.asList(-1, -2, -3)},
        {Arrays.asList(10, 20, 30), Arrays.asList(30, 20, 10)},
        {Arrays.asList(100, 200, 300), Arrays.asList(150, 250, 350)},
        {Arrays.asList(1, 1, 1, 1, 1), Arrays.asList(1, 1, 1, 1, 1)},
        {Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(5, 4, 3, 2, 1)},
        {Arrays.asList(0, 1, 2, 3, 4), Arrays.asList(4, 3, 2, 1, 0)},
        {Arrays.asList(-5, -10, -15), Arrays.asList(-15, -10, -5)}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("compare vs evaluateDifference Test Cases")
    void compare_vs_evaluateDifference(List<Integer> game, List<Integer> guess) {
        assertEquals(
            SourceCode.compare(game, guess),
            TransformedCode.evaluateDifference(game, guess)
        );
    }
}