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
    public static List<Integer> sortThird(List<Integer> l) {
        List<Integer> result = new ArrayList<>(l);
        List<Integer> everyThird = new ArrayList<>();
        
        for (int i = 0; i < result.size(); i += 3) {
            everyThird.add(result.get(i));
        }
        
        Collections.sort(everyThird);
        
        for (int i = 0, j = 0; i < result.size(); i += 3, j++) {
            result.set(i, everyThird.get(j));
        }
        
        return result;
    }

    // Transformed Code
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

    // Test Cases
    private static final List<List<Integer>> testCases = List.of(
        List.of(9, 2, 3, 6, 5, 4, 1, 8, 7),
        List.of(10, 20, 30, 40, 50, 60, 70, 80, 90),
        List.of(1, 2, 3),
        List.of(3, 2, 1, 6, 5, 4, 9, 8, 7),
        List.of(),
        List.of(5),
        List.of(5, 10),
        List.of(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5),
        List.of(7, 8, 9, 1, 2, 3, 4, 5, 6),
        List.of(0, 0, 0, 0, 0, 0, 0, 0, 0)
    );

    @Test
    public void test_0() {
        assertEquals(sortThird(testCases.get(0)), arrangeEveryThirdElement(testCases.get(0)));
    }

    @Test
    public void test_1() {
        assertEquals(sortThird(testCases.get(1)), arrangeEveryThirdElement(testCases.get(1)));
    }

    @Test
    public void test_2() {
        assertEquals(sortThird(testCases.get(2)), arrangeEveryThirdElement(testCases.get(2)));
    }

    @Test
    public void test_3() {
        assertEquals(sortThird(testCases.get(3)), arrangeEveryThirdElement(testCases.get(3)));
    }

    @Test
    public void test_4() {
        assertEquals(sortThird(testCases.get(4)), arrangeEveryThirdElement(testCases.get(4)));
    }

    @Test
    public void test_5() {
        assertEquals(sortThird(testCases.get(5)), arrangeEveryThirdElement(testCases.get(5)));
    }

    @Test
    public void test_6() {
        assertEquals(sortThird(testCases.get(6)), arrangeEveryThirdElement(testCases.get(6)));
    }

    @Test
    public void test_7() {
        assertEquals(sortThird(testCases.get(7)), arrangeEveryThirdElement(testCases.get(7)));
    }

    @Test
    public void test_8() {
        assertEquals(sortThird(testCases.get(8)), arrangeEveryThirdElement(testCases.get(8)));
    }

    @Test
    public void test_9() {
        assertEquals(sortThird(testCases.get(9)), arrangeEveryThirdElement(testCases.get(9)));
    }
}