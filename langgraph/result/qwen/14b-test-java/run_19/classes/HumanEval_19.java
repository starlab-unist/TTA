import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_19 {

    // Source Code
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

    // Transformed Code
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

    @Test
    public void test_0() {
        assertEquals(sortNumbers(testCases[0]), arrangeNumerals(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(sortNumbers(testCases[1]), arrangeNumerals(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(sortNumbers(testCases[2]), arrangeNumerals(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(sortNumbers(testCases[3]), arrangeNumerals(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(sortNumbers(testCases[4]), arrangeNumerals(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(sortNumbers(testCases[5]), arrangeNumerals(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(sortNumbers(testCases[6]), arrangeNumerals(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(sortNumbers(testCases[7]), arrangeNumerals(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(sortNumbers(testCases[8]), arrangeNumerals(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(sortNumbers(testCases[9]), arrangeNumerals(testCases[9]));
    }
}