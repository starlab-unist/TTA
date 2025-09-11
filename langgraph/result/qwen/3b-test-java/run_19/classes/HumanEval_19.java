import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_19 {

    // Source Code
    static class OriginalImpl {
        public static String sortNumbers(String numbers) {
            Map<String, Integer> valueMap = new HashMap<>();
            valueMap.put("zero", 0);
            valueMap.put("one", 1);
            valueMap.put("two", 2);
            valueMap.put("three", 3);
            valueMap.put("four", 4);
            valueMap.put("five", 5);
            valueMap.put("six", 6);
            valueMap.put("seven", 7);
            valueMap.put("eight", 8);
            valueMap.put("nine", 9);

            List<String> numberList = Arrays.asList(numbers.split(" "));
            Collections.sort(numberList, Comparator.comparingInt(valueMap::get));

            return String.join(" ", numberList);
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public static String arrangeNumerals(String numberString) {
            Map<String, Integer> numeralToDigit = new HashMap<>();
            numeralToDigit.put("zero", 0);
            numeralToDigit.put("one", 1);
            numeralToDigit.put("two", 2);
            numeralToDigit.put("three", 3);
            numeralToDigit.put("four", 4);
            numeralToDigit.put("five", 5);
            numeralToDigit.put("six", 6);
            numeralToDigit.put("seven", 7);
            numeralToDigit.put("eight", 8);
            numeralToDigit.put("nine", 9);

            // Split the input string and filter out any empty strings
            List<String> numeralList = Arrays.asList(numberString.split(" "))
                    .stream()
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());

            // Sort the list based on the mapped digit values
            Collections.sort(numeralList, Comparator.comparingInt(n -> numeralToDigit.get(n)));

            // Join the sorted numerals back into a single string
            return String.join(" ", numeralList);
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.arguments("three one four one five nine"),
            Arguments.arguments("nine eight seven six five four three two one zero"),
            Arguments.arguments("zero zero zero"),
            Arguments.arguments("one two three four five six seven eight nine"),
            Arguments.arguments("four four four four four"),
            Arguments.arguments("five six seven eight nine zero one two three"),
            Arguments.arguments("two four six eight"),
            Arguments.arguments("one three five seven nine"),
            Arguments.arguments(""),
            Arguments.arguments("nine")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testSortAndArrangeNumerals(String input) {
        assertEquals(OriginalImpl.sortNumbers(input), TransformedImpl.arrangeNumerals(input));
    }
}