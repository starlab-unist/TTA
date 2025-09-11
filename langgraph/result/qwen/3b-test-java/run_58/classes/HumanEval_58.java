import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_58 {

    // Source Code
    public static List<Integer> common(List<Integer> l1, List<Integer> l2) {
        Set<Integer> ret = new HashSet<>();
        for (Integer e1 : l1) {
            for (Integer e2 : l2) {
                if (e1.equals(e2)) {
                    ret.add(e1);
                }
            }
        }
        return ret.stream().sorted().collect(Collectors.toList());
    }

    // Transformed Code
    public static List<Integer> findSharedElements(List<Integer> listA, List<Integer> listB) {
        Set<Integer> sharedItems = new HashSet<>();
        Iterator<Integer> iteratorA = listA.iterator();

        while (iteratorA.hasNext()) {
            Integer elementA = iteratorA.next();
            for (Integer elementB : listB) {
                if (elementA.equals(elementB)) {
                    sharedItems.add(elementA);
                }
            }
        }

        return new ArrayList<>(sharedItems);
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 4)},
        {Arrays.asList(10, 20, 30), Arrays.asList(40, 50, 60)},
        {Arrays.asList(), Arrays.asList()},
        {Arrays.asList(1, 1, 2, 2), Arrays.asList(2, 2, 3, 3)},
        {Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(3, 4, 5, 6, 7)},
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_58.common((List<Integer>) testCases[0][0], (List<Integer>) testCases[0][1]), 
                     HumanEval_58.findSharedElements((List<Integer>) testCases[0][0], (List<Integer>) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_58.common((List<Integer>) testCases[1][0], (List<Integer>) testCases[1][1]), 
                     HumanEval_58.findSharedElements((List<Integer>) testCases[1][0], (List<Integer>) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_58.common((List<Integer>) testCases[2][0], (List<Integer>) testCases[2][1]), 
                     HumanEval_58.findSharedElements((List<Integer>) testCases[2][0], (List<Integer>) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_58.common((List<Integer>) testCases[3][0], (List<Integer>) testCases[3][1]), 
                     HumanEval_58.findSharedElements((List<Integer>) testCases[3][0], (List<Integer>) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_58.common((List<Integer>) testCases[4][0], (List<Integer>) testCases[4][1]), 
                     HumanEval_58.findSharedElements((List<Integer>) testCases[4][0], (List<Integer>) testCases[4][1]));
    }
}