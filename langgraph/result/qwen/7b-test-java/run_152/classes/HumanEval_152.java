import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_152 {

    // Source Code
    static class OriginalImpl {
        public static int[] compare(int[] game, int[] guess) {
            int[] result = new int[game.length];
            for (int i = 0; i < game.length; i++) {
                result[i] = Math.abs(game[i] - guess[i]);
            }
            return result;
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public static List<Integer> evaluateDifference(List<Integer> actual, List<Integer> guess) {
            List<Integer> differences = new ArrayList<>();
            int index = 0;
            while (index < actual.size()) {
                differences.add(Math.abs(actual.get(index) - guess.get(index)));
                index++;
            }
            return differences;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3}),
            Arguments.of(new int[]{4, 5, 6}, new int[]{7, 8, 9}),
            Arguments.of(new int[]{0, 0, 0}, new int[]{1, 1, 1}),
            Arguments.of(new int[]{-1, -2, -3}, new int[]{-1, -2, -3}),
            Arguments.of(new int[]{10, 20, 30}, new int[]{30, 20, 10}),
            Arguments.of(new int[]{100, 200, 300}, new int[]{150, 250, 350}),
            Arguments.of(new int[]{1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1}),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}),
            Arguments.of(new int[]{0, 1, 2, 3, 4}, new int[]{4, 3, 2, 1, 0}),
            Arguments.of(new int[]{-5, -10, -15}, new int[]{-15, -10, -5})
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testCompare(int[] game, int[] guess) {
        // Convert input arrays to lists for the transformed implementation
        List<Integer> gameList = Arrays.stream(game).boxed().toList();
        List<Integer> guessList = Arrays.stream(guess).boxed().toList();

        // Get results from both implementations
        int[] originalResult = OriginalImpl.compare(game, guess);
        List<Integer> transformedResult = TransformedImpl.evaluateDifference(gameList, guessList);

        // Compare results: convert original result to list for comparison
        assertEquals(Arrays.stream(originalResult).boxed().toList(), transformedResult);
    }
}