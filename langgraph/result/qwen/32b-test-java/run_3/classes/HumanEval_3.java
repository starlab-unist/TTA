import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_3 {

    // Source Code
    static class HumanEval_3_Source {
        public boolean belowZero(List<Integer> operations) {
            int balance = 0;

            for (int op : operations) {
                balance += op;
                if (balance < 0) {
                    return true;
                }
            }

            return false;
        }
    }

    // Transformed Code
    static class HumanEval_3_Transformed {
        public boolean checkNegativeBalance(List<Integer> transactions) {
            int currentBalance = 0;

            int index = 0;
            while (index < transactions.size()) {
                currentBalance += transactions.get(index);
                if (currentBalance < 0) {
                    return true;
                }
                index++;
            }

            return false;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(), false},
        {Arrays.asList(1, 2, 3), false},
        {Arrays.asList(-1, -2, -3), true},
        {Arrays.asList(10, -5, -6), true},
        {Arrays.asList(10, -5, 5), false},
        {Arrays.asList(0, 0, 0), false},
        {Arrays.asList(1, -1, 1, -1, 1, -2), true},
        {Arrays.asList(-1, 1, -1, 1, -1, 1), true},
        {Arrays.asList(1, 2, 3, -7), true},
        {Arrays.asList(5, 5, 5, 5, -20), true}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(args -> Arguments.of((List<Integer>) args[0], (Boolean) args[1]));
    }

    @DisplayName("Testing equivalence between belowZero and checkNegativeBalance")
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void belowZero_vs_checkNegativeBalance(List<Integer> input, Boolean expected) {
        assertEquals(
            HumanEval_3_Source.belowZero(input),
            HumanEval_3_Transformed.checkNegativeBalance(input)
        );
    }
}