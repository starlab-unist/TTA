import java.util.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_19 {

    // Source Code
    static class HumanEval_19_Source {
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

            String[] numberArray = numbers.split(" ");
            Arrays.sort(numberArray, Comparator.comparingInt(valueMap::get));

            return String.join(" ", numberArray);
        }
    }

    // Transformed Code
    static class HumanEval_19_Transformed {
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
            String[] numeralArray = numberString.split(" ");
            List<String> numeralList = new ArrayList<>();
            for (String numeral : numeralArray) {
                if (!numeral.isEmpty()) {
                    numeralList.add(numeral);
                }
            }

            // Sort the list based on the mapped digit values
            numeralList.sort(Comparator.comparingInt(numeralToDigit::get));

            // Join the sorted numerals back into a single string
            return String.join(" ", numeralList);
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "three one four one five nine",
        "nine eight seven six five four three two one zero",
        "zero zero zero",
        "one two three four five six seven eight nine",
        "four four four four four",
        "five six seven eight nine zero one two three",
        "two four six eight",
        "one three five seven nine",
        "",
        "nine"
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void sortNumbers_vs_arrangeNumerals(String inputText) {
        assertEquals(
            HumanEval_19_Source.sortNumbers(inputText),
            HumanEval_19_Transformed.arrangeNumerals(inputText)
        );
    }
}