// Source Code
class HumanEval_3 {
    public static boolean belowZero(List<Integer> operations) {
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
class TransformedCode_HumanEval_3 {

    public static boolean checkNegativeBalance(List<Integer> transactions) {
        int currentBalance = 0;

        int index = 0;
        while (index < transactions.size()) {
            currentBalance += transactions.get(index);
            if (currentBalance < 0) {
                return true;
            }
            index += 1;
        }

        return false;
    }
}

// Test Cases
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_3 {

    private static final List<Arguments> testCases = Arrays.asList(
        Arguments.of(Arrays.asList(), false),
        Arguments.of(Arrays.asList(1, 2, 3), false),
        Arguments.of(Arrays.asList(-1, -2, -3), true),
        Arguments.of(Arrays.asList(10, -5, -6), true),
        Arguments.of(Arrays.asList(10, -5, 5), false),
        Arguments.of(Arrays.asList(0, 0, 0), false),
        Arguments.of(Arrays.asList(1, -1, 1, -1, 1, -2), true),
        Arguments.of(Arrays.asList(-1, 1, -1, 1, -1, 1), true),
        Arguments.of(Arrays.asList(1, 2, 3, -7), true),
        Arguments.of(Arrays.asList(5, 5, 5, 5, -20), true)
    );

    private static Stream<Arguments> provideTestCases() {
        return testCases.stream();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void belowZero_vs_checkNegativeBalance(List<Integer> inputOperations) {
        assertEquals(
            HumanEval_3.belowZero(inputOperations),
            TransformedCode_HumanEval_3.checkNegativeBalance(inputOperations)
        );
    }
}