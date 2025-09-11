import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_105 {

    // Source Code
    public static List<String> byLength(List<Integer> arr) {
        Map<Integer, String> dic = new HashMap<>();
        dic.put(1, "One");
        dic.put(2, "Two");
        dic.put(3, "Three");
        dic.put(4, "Four");
        dic.put(5, "Five");
        dic.put(6, "Six");
        dic.put(7, "Seven");
        dic.put(8, "Eight");
        dic.put(9, "Nine");

        Collections.sort(arr, Collections.reverseOrder());
        List<String> new_arr = new ArrayList<>();

        for (Integer var : arr) {
            try {
                new_arr.add(dic.get(var));
            } catch (NullPointerException e) {
                // Ignore non-existent keys
            }
        }

        return new_arr;
    }

    // Transformed Code
    public static List<String> arrangeByNumberName(List<Integer> numbers) {
        Map<Integer, String> numberNames = new HashMap<>();
        numberNames.put(1, "One");
        numberNames.put(2, "Two");
        numberNames.put(3, "Three");
        numberNames.put(4, "Four");
        numberNames.put(5, "Five");
        numberNames.put(6, "Six");
        numberNames.put(7, "Seven");
        numberNames.put(8, "Eight");
        numberNames.put(9, "Nine");

        List<Integer> descendingNumbers = new ArrayList<>(numbers);
        descendingNumbers.sort(Collections.reverseOrder());

        List<String> namedNumbers = new ArrayList<>();
        int index = 0;
        while (index < descendingNumbers.size()) {
            int num = descendingNumbers.get(index);
            if (numberNames.containsKey(num)) {
                namedNumbers.add(numberNames.get(num));
            }
            index++;
        }

        return namedNumbers;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {List.of(3, 2, 1), List.of("Three", "Two", "One")},
        {List.of(9, 8, 7, 6, 5), List.of("Nine", "Eight", "Seven", "Six", "Five")},
        {List.of(4, 4, 4, 4), List.of("Four", "Four", "Four", "Four")},
        {List.of(10, 11, 12), List.of()}, // should return empty as none are in the dictionary
        {List.of(), List.of()},
        {List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), List.of("Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two", "One")},
        {List.of(9, 3, 5, 7, 1), List.of("Nine", "Seven", "Five", "Three", "One")},
        {List.of(2, 2, 2, 3, 3, 1), List.of("Three", "Three", "Two", "Two", "Two", "One")},
        {List.of(5), List.of("Five")}, // single element
        {List.of(0, -1, 10), List.of()}   // should return empty as none are in the dictionary
    };

    @Test
    public void test_0() {
        assertEquals(byLength((List<Integer>) testCases[0][0]), 
                     arrangeByNumberName((List<Integer>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(byLength((List<Integer>) testCases[1][0]), 
                     arrangeByNumberName((List<Integer>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(byLength((List<Integer>) testCases[2][0]), 
                     arrangeByNumberName((List<Integer>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(byLength((List<Integer>) testCases[3][0]), 
                     arrangeByNumberName((List<Integer>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(byLength((List<Integer>) testCases[4][0]), 
                     arrangeByNumberName((List<Integer>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(byLength((List<Integer>) testCases[5][0]), 
                     arrangeByNumberName((List<Integer>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(byLength((List<Integer>) testCases[6][0]), 
                     arrangeByNumberName((List<Integer>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(byLength((List<Integer>) testCases[7][0]), 
                     arrangeByNumberName((List<Integer>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(byLength((List<Integer>) testCases[8][0]), 
                     arrangeByNumberName((List<Integer>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(byLength((List<Integer>) testCases[9][0]), 
                     arrangeByNumberName((List<Integer>) testCases[9][0]));
    }
}