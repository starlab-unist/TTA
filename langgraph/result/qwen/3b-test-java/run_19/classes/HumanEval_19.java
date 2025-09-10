import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

public class HumanEval_19 {

    // Nested class for the original implementation
    public static class OriginalImpl {
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

    // Nested class for the transformed implementation
    public static class TransformedImpl {
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

    // Method to provide test cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of("three one four one five nine"),
            Arguments.of("nine eight seven six five four three two one zero"),
            Arguments.of("zero zero zero"),
            Arguments.of("one two three four five six seven eight nine"),
            Arguments.of("four four four four four"),
            Arguments.of("five six seven eight nine zero one two three"),
            Arguments.of("two four six eight"),
            Arguments.of("one three five seven nine"),
            Arguments.of(""),
            Arguments.of("nine")
        );
    }

    // Parameterized test method
    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void test(String input) {
        assertEquals(OriginalImpl.sortNumbers(input), TransformedImpl.arrangeNumerals(input));
    }
}