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
    static class HumanEval_105_Source {
        public static List<String> byLength(int[] arr) {
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

            Arrays.sort(arr);
            List<String> newArr = new ArrayList<>();
            for (int var : arr) {
                if (dic.containsKey(var)) {
                    newArr.add(dic.get(var));
                }
            }
            Collections.reverse(newArr);
            return newArr;
        }
    }

    // Transformed Code
    static class HumanEval_105_Transformed {
        public static List<String> arrangeByNumberName(int[] numbers) {
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

            List<Integer> descendingNumbers = Arrays.stream(numbers)
                    .boxed()
                    .sorted(Comparator.reverseOrder())
                    .toList();

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
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new int[]{3, 2, 1}},
        {new int[]{9, 8, 7, 6, 5}},
        {new int[]{4, 4, 4, 4}},
        {new int[]{10, 11, 12}},  // should return empty as none are in the dictionary
        {new int[]{}},
        {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}},
        {new int[]{9, 3, 5, 7, 1}},
        {new int[]{2, 2, 2, 3, 3, 1}},
        {new int[]{5}},  // single element
        {new int[]{0, -1, 10}}   // should return empty as none are in the dictionary
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_105_Source.byLength((int[]) testCases[0][0]), 
                     HumanEval_105_Transformed.arrangeByNumberName((int[]) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_105_Source.byLength((int[]) testCases[1][0]), 
                     HumanEval_105_Transformed.arrangeByNumberName((int[]) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_105_Source.byLength((int[]) testCases[2][0]), 
                     HumanEval_105_Transformed.arrangeByNumberName((int[]) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_105_Source.byLength((int[]) testCases[3][0]), 
                     HumanEval_105_Transformed.arrangeByNumberName((int[]) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_105_Source.byLength((int[]) testCases[4][0]), 
                     HumanEval_105_Transformed.arrangeByNumberName((int[]) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_105_Source.byLength((int[]) testCases[5][0]), 
                     HumanEval_105_Transformed.arrangeByNumberName((int[]) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_105_Source.byLength((int[]) testCases[6][0]), 
                     HumanEval_105_Transformed.arrangeByNumberName((int[]) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_105_Source.byLength((int[]) testCases[7][0]), 
                     HumanEval_105_Transformed.arrangeByNumberName((int[]) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_105_Source.byLength((int[]) testCases[8][0]), 
                     HumanEval_105_Transformed.arrangeByNumberName((int[]) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_105_Source.byLength((int[]) testCases[9][0]), 
                     HumanEval_105_Transformed.arrangeByNumberName((int[]) testCases[9][0]));
    }
}