import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class HumanEval_104 {

    // Source Code
    static class OriginalImpl {
        public List<Integer> uniqueDigits(List<Integer> x) {
            List<Integer> oddDigitElements = new ArrayList<>();
            for (Integer i : x) {
                if (allOddDigits(i)) {
                    oddDigitElements.add(i);
                }
            }
            oddDigitElements.sort(null);
            return oddDigitElements;
        }

        private boolean allOddDigits(Integer number) {
            String numStr = number.toString();
            for (char c : numStr.toCharArray()) {
                if ((c - '0') % 2 == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public List<Integer> filterOddDigitNumbers(List<Integer> numbers) {
            List<Integer> oddDigitNumbers = new ArrayList<>();
            for (Integer number : numbers) {
                boolean hasOnlyOddDigits = true;
                for (char digit : String.valueOf(number).toCharArray()) {
                    if ((digit - '0') % 2 == 0) {
                        hasOnlyOddDigits = false;
                        break;
                    }
                }
                if (hasOnlyOddDigits) {
                    oddDigitNumbers.add(number);
                }
            }
            
            oddDigitNumbers.sort(null);
            return oddDigitNumbers;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(new ArrayList<>(Arrays.asList(135, 246, 357, 579))),
            Arguments.of(new ArrayList<>(Arrays.asList(111, 333, 555, 777, 999))),
            Arguments.of(new ArrayList<>(Arrays.asList(222, 444, 666, 888))),
            Arguments.of(new ArrayList<>(Arrays.asList(13579, 2468, 12345))),
            Arguments.of(new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9))),
            Arguments.of(new ArrayList<>(Arrays.asList(0, 2, 4, 6, 8))),
            Arguments.of(new ArrayList<>(Arrays.asList(135, 579, 791, 913))),
            Arguments.of(new ArrayList<>(Arrays.asList())),
            Arguments.of(new ArrayList<>(Arrays.asList(113, 135, 357, 579))),
            Arguments.of(new ArrayList<>(Arrays.asList(123, 321, 213, 456)))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void test(List<Integer> testCase) {
        OriginalImpl original = new OriginalImpl();
        TransformedImpl transformed = new TransformedImpl();
        
        assertEquals(original.uniqueDigits(testCase), transformed.filterOddDigitNumbers(testCase));
    }
}