import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_67 {

    // Source Code
    static class SourceCode {
        public static int fruitDistribution(String s, int n) {
            List<Integer> lis = new ArrayList<>();
            for (String i : s.split(" ")) {
                if (i.matches("\\d+")) {
                    lis.add(Integer.parseInt(i));
                }
            }
            return n - lis.stream().mapToInt(Integer::intValue).sum();
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static int calculateRemainingFruits(String fruitString, int totalFruits) {
            List<Integer> numbers = new ArrayList<>();
            for (String item : fruitString.split(" ")) {
                if (item.matches("\\d+")) {
                    numbers.add(Integer.parseInt(item));
                }
            }
            int remainingFruits = totalFruits - numbers.stream().mapToInt(Integer::intValue).sum();
            return remainingFruits;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {"1 2 3", 10},
        {"5 5 5", 20},
        {"", 10},
        {"10 20 30", 100},
        {"100", 150},
        {"1 2 3 4 5", 20},
        {"7 8 9", 30},
        {"0 0 0", 5},
        {"123", 200},
        {"456 789", 1500}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void fruitDistribution_vs_calculateRemainingFruits(String inputString, int totalFruits) {
        assertEquals(
            SourceCode.fruitDistribution(inputString, totalFruits),
            TransformedCode.calculateRemainingFruits(inputString, totalFruits)
        );
    }
}