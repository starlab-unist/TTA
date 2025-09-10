import java.util.*;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_19 {

    // Source Code
    static class SourceCode {
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
            List<String> filteredList = new ArrayList<>();
            for (String num : numberArray) {
                if (!num.isEmpty()) {
                    filteredList.add(num);
                }
            }

            Collections.sort(filteredList, Comparator.comparingInt(valueMap::get));

            return String.join(" ", filteredList);
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static String arrangeNumerals(String numberString) { // Made static here
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

            List<String> numeralList = new ArrayList<>(Arrays.asList(numberString.split(" ")));
            numeralList.removeIf(String::isEmpty);

            numeralList.sort(Comparator.comparingInt(numeralToDigit::get));

            return String.join(" ", numeralList);
        }
    }

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
            SourceCode.sortNumbers(inputText),
            TransformedCode.arrangeNumerals(inputText)
        );
    }
}