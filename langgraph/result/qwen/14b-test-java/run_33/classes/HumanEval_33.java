import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_33 {

    // Source Code
    static class HumanEval_33_Source {
        public static List<Integer> sortThird(List<Integer> l) {
            List<Integer> result = new ArrayList<>(l);
            List<Integer> thirdElements = new ArrayList<>();
            
            for (int i = 0; i < result.size(); i += 3) {
                thirdElements.add(result.get(i));
            }
            
            Collections.sort(thirdElements);
            
            for (int i = 0, j = 0; i < result.size(); i += 3, j++) {
                result.set(i, thirdElements.get(j));
            }
            
            return result;
        }
    }

    // Transformed Code
    static class HumanEval_33_Transformed {
        public static List<Integer> arrangeEveryThirdElement(List<Integer> inputList) {
            List<Integer> elementsToSort = new ArrayList<>();
            for (int i = 0; i < inputList.size(); i += 3) {
                elementsToSort.add(inputList.get(i));
            }
            Collections.sort(elementsToSort);
            
            List<Integer> resultList = new ArrayList<>(inputList);
            for (int index = 0; index < elementsToSort.size(); index++) {
                resultList.set(index * 3, elementsToSort.get(index));
            }
            return resultList;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new ArrayList<>(List.of(9, 2, 3, 6, 5, 4, 1, 8, 7))},
        {new ArrayList<>(List.of(10, 20, 30, 40, 50, 60, 70, 80, 90))},
        {new ArrayList<>(List.of(1, 2, 3))},
        {new ArrayList<>(List.of(3, 2, 1, 6, 5, 4, 9, 8, 7))},
        {new ArrayList<>(List.of())},
        {new ArrayList<>(List.of(5))},
        {new ArrayList<>(List.of(5, 10))},
        {new ArrayList<>(List.of(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5))},
        {new ArrayList<>(List.of(7, 8, 9, 1, 2, 3, 4, 5, 6))},
        {new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0))}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_33_Source.sortThird((List<Integer>) testCases[0][0]), 
                     HumanEval_33_Transformed.arrangeEveryThirdElement((List<Integer>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_33_Source.sortThird((List<Integer>) testCases[1][0]), 
                     HumanEval_33_Transformed.arrangeEveryThirdElement((List<Integer>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_33_Source.sortThird((List<Integer>) testCases[2][0]), 
                     HumanEval_33_Transformed.arrangeEveryThirdElement((List<Integer>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_33_Source.sortThird((List<Integer>) testCases[3][0]), 
                     HumanEval_33_Transformed.arrangeEveryThirdElement((List<Integer>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_33_Source.sortThird((List<Integer>) testCases[4][0]), 
                     HumanEval_33_Transformed.arrangeEveryThirdElement((List<Integer>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_33_Source.sortThird((List<Integer>) testCases[5][0]), 
                     HumanEval_33_Transformed.arrangeEveryThirdElement((List<Integer>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_33_Source.sortThird((List<Integer>) testCases[6][0]), 
                     HumanEval_33_Transformed.arrangeEveryThirdElement((List<Integer>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_33_Source.sortThird((List<Integer>) testCases[7][0]), 
                     HumanEval_33_Transformed.arrangeEveryThirdElement((List<Integer>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_33_Source.sortThird((List<Integer>) testCases[8][0]), 
                     HumanEval_33_Transformed.arrangeEveryThirdElement((List<Integer>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_33_Source.sortThird((List<Integer>) testCases[9][0]), 
                     HumanEval_33_Transformed.arrangeEveryThirdElement((List<Integer>) testCases[9][0]));
    }
}