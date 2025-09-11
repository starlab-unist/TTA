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

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Collections;
import java.util.Iterator;

public class HumanEval_104 {

    // Source Code
    static class OriginalImpl {
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
    static class TransformedImpl {
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

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.arguments(new ArrayList<>(Arrays.asList(135, 246, 357, 579)), new ArrayList<>(Arrays.asList(135, 357, 579))),
            Arguments.arguments(new ArrayList<>(Arrays.asList(111, 333, 555, 777, 999)), new ArrayList<>(Arrays.asList(111, 333, 555, 777, 999))),
            Arguments.arguments(new ArrayList<>(Arrays.asList(222, 444, 666, 888)), new ArrayList<>()),
            Arguments.arguments(new ArrayList<>(Arrays.asList(13579, 2468, 12345)), new ArrayList<>(Arrays.asList(13579))),
            Arguments.arguments(new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9)), new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9))),
            Arguments.arguments(new ArrayList<>(Arrays.asList(0, 2, 4, 6, 8)), new ArrayList<>()),
            Arguments.arguments(new ArrayList<>(Arrays.asList(135, 579, 791, 913)), new ArrayList<>(Arrays.asList(135, 579, 791, 913))),
            Arguments.arguments(new ArrayList<>(), new ArrayList<>()),
            Arguments.arguments(new ArrayList<>(Arrays.asList(113, 135, 357, 579)), new ArrayList<>(Arrays.asList(113, 135, 357, 579))),
            Arguments.arguments(new ArrayList<>(Arrays.asList(123, 321, 213, 456)), new ArrayList<>())
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void test(List<Integer> input, List<Integer> expected) {
        assertEquals(OriginalImpl.uniqueDigits(input), 
                     new TransformedImpl().filterOddDigitNumbers(input));
    }
}