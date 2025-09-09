import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_67 {

    // Source Code
    static class SourceCode {
        public int fruitDistribution(String s, int n) {
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
        public int calculateRemainingFruits(String fruitString, int totalFruits) {
            List<Integer> numbers = new ArrayList<>();
            for (String item : fruitString.split("\\s+")) {
                if (item.matches("\\d+")) {
                    numbers.add(Integer.parseInt(item));
                }
            }
            int remainingFruits = totalFruits - numbers.stream().mapToInt(Integer::intValue).sum();
            return remainingFruits;
        }
    }

    // Test Cases
    private static final Arguments[] testCases = {
        Arguments.of("1 2 3", 10),
        Arguments.of("5 5 5", 20),
        Arguments.of("", 10),
        Arguments.of("10 20 30", 100),
        Arguments.of("100", 150),
        Arguments.of("1 2 3 4 5", 20),
        Arguments.of("7 8 9", 30),
        Arguments.of("0 0 0", 5),
        Arguments.of("123", 200),
        Arguments.of("456 789", 1500)
    };

    private static java.util.stream.Stream<Arguments> provideTestCases() {
        return java.util.Arrays.stream(testCases);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Test equivalence of fruitDistribution and calculateRemainingFruits methods")
    void testEquivalence(String inputString, int totalFruits) {
        assertEquals(
            SourceCode.fruitDistribution(inputString, totalFruits),
            TransformedCode.calculateRemainingFruits(inputString, totalFruits)
        );
    }
}