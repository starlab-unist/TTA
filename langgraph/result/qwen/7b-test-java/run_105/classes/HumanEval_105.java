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

            List<Integer> sortedArr = new ArrayList<>(arr);
            Collections.sort(sortedArr, Collections.reverseOrder());
            List<String> newArr = new ArrayList<>();

            for (int var : sortedArr) {
                if (dic.containsKey(var)) {
                    newArr.add(dic.get(var));
                }
            }

            return newArr;
        }
    }

    // Transformed Code
    static class HumanEval_105_Transformed {
        public List<String> byLength(List<Integer> arr) {
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

            List<Integer> sortedArr = new ArrayList<>(arr);
            Collections.sort(sortedArr, Collections.reverseOrder());

            List<String> new_arr = new ArrayList<>();
            int index = 0;
            while (index < sortedArr.size()) {
                int num = sortedArr.get(index);
                if (dic.containsKey(num)) {
                    new_arr.add(dic.get(num));
                }
                index++;
            }
            return new_arr;
        }
    }

    // Test Cases
    private static final List<Integer>[] testCases = new List[]{
        Arrays.asList(3, 2, 1),
        Arrays.asList(9, 8, 7, 6, 5),
        Arrays.asList(4, 4, 4, 4),
        Arrays.asList(10, 11, 12),  // should return empty as none are in the dictionary
        Arrays.asList(),
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9),
        Arrays.asList(9, 3, 5, 7, 1),
        Arrays.asList(2, 2, 2, 3, 3, 1),
        Arrays.asList(5),  // single element
        Arrays.asList(0, -1, 10)   // should return empty as none are in the dictionary
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_105_Source.byLength(testCases[0]), 
                     new HumanEval_105_Transformed().byLength(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_105_Source.byLength(testCases[1]), 
                     new HumanEval_105_Transformed().byLength(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_105_Source.byLength(testCases[2]), 
                     new HumanEval_105_Transformed().byLength(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_105_Source.byLength(testCases[3]), 
                     new HumanEval_105_Transformed().byLength(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_105_Source.byLength(testCases[4]), 
                     new HumanEval_105_Transformed().byLength(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_105_Source.byLength(testCases[5]), 
                     new HumanEval_105_Transformed().byLength(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_105_Source.byLength(testCases[6]), 
                     new HumanEval_105_Transformed().byLength(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_105_Source.byLength(testCases[7]), 
                     new HumanEval_105_Transformed().byLength(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_105_Source.byLength(testCases[8]), 
                     new HumanEval_105_Transformed().byLength(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_105_Source.byLength(testCases[9]), 
                     new HumanEval_105_Transformed().byLength(testCases[9]));
    }
}