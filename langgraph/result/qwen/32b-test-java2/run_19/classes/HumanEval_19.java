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
    static class HumanEval_19_Transformed {
        public String arrangeNumerals(String numberString) {
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
            List<String> numeralList = new ArrayList<>(Arrays.asList(numberString.split(" ")));
            numeralList.removeIf(String::isEmpty);

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

    @Test
    public void test_0() {
        assertEquals(HumanEval_19_Source.sortNumbers(testCases[0]), 
                     new HumanEval_19_Transformed().arrangeNumerals(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_19_Source.sortNumbers(testCases[1]), 
                     new HumanEval_19_Transformed().arrangeNumerals(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_19_Source.sortNumbers(testCases[2]), 
                     new HumanEval_19_Transformed().arrangeNumerals(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_19_Source.sortNumbers(testCases[3]), 
                     new HumanEval_19_Transformed().arrangeNumerals(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_19_Source.sortNumbers(testCases[4]), 
                     new HumanEval_19_Transformed().arrangeNumerals(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_19_Source.sortNumbers(testCases[5]), 
                     new HumanEval_19_Transformed().arrangeNumerals(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_19_Source.sortNumbers(testCases[6]), 
                     new HumanEval_19_Transformed().arrangeNumerals(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_19_Source.sortNumbers(testCases[7]), 
                     new HumanEval_19_Transformed().arrangeNumerals(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_19_Source.sortNumbers(testCases[8]), 
                     new HumanEval_19_Transformed().arrangeNumerals(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_19_Source.sortNumbers(testCases[9]), 
                     new HumanEval_19_Transformed().arrangeNumerals(testCases[9]));
    }
}