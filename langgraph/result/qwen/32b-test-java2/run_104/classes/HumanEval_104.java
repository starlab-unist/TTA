import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_104 {

    // Source Code
    static class SourceCode {
        public static List<Integer> uniqueDigits(List<Integer> x) {
            List<Integer> oddDigitElements = new ArrayList<>();
            for (Integer i : x) {
                boolean allOdd = true;
                for (char c : i.toString().toCharArray()) {
                    if ((c - '0') % 2 == 0) {
                        allOdd = false;
                        break;
                    }
                }
                if (allOdd) {
                    oddDigitElements.add(i);
                }
            }
            Collections.sort(oddDigitElements);
            return oddDigitElements;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public List<Integer> filterOddDigitNumbers(List<Integer> numbers) {
            List<Integer> oddDigitNumbers = new ArrayList<>();
            Iterator<Integer> iterator = numbers.iterator();
            
            while (iterator.hasNext()) {
                int number = iterator.next();
                String numberStr = Integer.toString(number);
                boolean allOddDigits = true;
                
                for (char digit : numberStr.toCharArray()) {
                    if ((digit - '0') % 2 == 0) {
                        allOddDigits = false;
                        break;
                    }
                }
                
                if (allOddDigits) {
                    oddDigitNumbers.add(number);
                }
            }
            
            Collections.sort(oddDigitNumbers);
            return oddDigitNumbers;
        }
    }

    private static final List<Arguments> testCases = Arrays.asList(
        Arguments.of(Arrays.asList(135, 246, 357, 579)),
        Arguments.of(Arrays.asList(111, 333, 555, 777, 999)),
        Arguments.of(Arrays.asList(222, 444, 666, 888)),
        Arguments.of(Arrays.asList(13579, 2468, 12345)),
        Arguments.of(Arrays.asList(1, 3, 5, 7, 9)),
        Arguments.of(Arrays.asList(0, 2, 4, 6, 8)),
        Arguments.of(Arrays.asList(135, 579, 791, 913)),
        Arguments.of(Arrays.asList()),
        Arguments.of(Arrays.asList(113, 135, 357, 579)),
        Arguments.of(Arrays.asList(123, 321, 213, 456))
    );

    private static Stream<Arguments> provideTestCases() {
        return testCases.stream();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void uniqueDigits_vs_filterOddDigitNumbers(List<Integer> inputList) {
        assertEquals(
            SourceCode.uniqueDigits(inputList),
            new TransformedCode().filterOddDigitNumbers(inputList)
        );
    }
}