import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_3 {

    // Original Implementation
    static class OriginalImpl {
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

    // Transformed Implementation
    static class TransformedImpl {
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

    // Method to provide test cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(List.of(), false),
            Arguments.of(List.of(1, 2, 3), false),
            Arguments.of(List.of(-1, -2, -3), true),
            Arguments.of(List.of(10, -5, -6), true),
            Arguments.of(List.of(10, -5, 5), false),
            Arguments.of(List.of(0, 0, 0), false),
            Arguments.of(List.of(1, -1, 1, -1, 1, -2), true),
            Arguments.of(List.of(-1, 1, -1, 1, -1, 1), true),
            Arguments.of(List.of(1, 2, 3, -7), true),
            Arguments.of(List.of(5, 5, 5, 5, -20), true)
        );
    }

    // Parameterized test method
    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testBelowZero(List<Integer> input, boolean expected) {
        OriginalImpl original = new OriginalImpl();
        TransformedImpl transformed = new TransformedImpl();

        assertEquals(original.belowZero(input), transformed.checkNegativeBalance(input));
    }
}