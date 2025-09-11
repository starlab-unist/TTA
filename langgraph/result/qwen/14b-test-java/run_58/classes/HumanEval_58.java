import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;
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
        List<Integer> result = new ArrayList<>(ret);
        Collections.sort(result);
        return result;
    }

    // Transformed Code
    public static List<Integer> find_shared_elements(List<Integer> list_a, List<Integer> list_b) {
        Set<Integer> sharedItems = new HashSet<>();
        Iterator<Integer> iteratorA = list_a.iterator();
        
        while (iteratorA.hasNext()) {
            Integer elementA = iteratorA.next();
            for (Integer elementB : list_b) {
                if (elementA.equals(elementB)) {
                    sharedItems.add(elementA);
                }
            }
        }
        
        List<Integer> result = new ArrayList<>(sharedItems);
        Collections.sort(result);
        return result;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {List.of(1, 2, 3), List.of(2, 3, 4)},
        {List.of(), List.of()},
        {List.of(10, 20, 30), List.of(40, 50, 60)},
        {List.of(1, 1, 2, 2), List.of(2, 2, 3, 3)},
        {List.of(1, 2, 3, 4, 5), List.of(3, 4, 5, 6, 7)},
        {List.of(null, null, null), List.of(null)}
    };

    @Test
    public void test_0() {
        assertEquals(common((List<Integer>) testCases[0][0], (List<Integer>) testCases[0][1]), 
                     find_shared_elements((List<Integer>) testCases[0][0], (List<Integer>) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(common((List<Integer>) testCases[1][0], (List<Integer>) testCases[1][1]), 
                     find_shared_elements((List<Integer>) testCases[1][0], (List<Integer>) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(common((List<Integer>) testCases[2][0], (List<Integer>) testCases[2][1]), 
                     find_shared_elements((List<Integer>) testCases[2][0], (List<Integer>) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(common((List<Integer>) testCases[3][0], (List<Integer>) testCases[3][1]), 
                     find_shared_elements((List<Integer>) testCases[3][0], (List<Integer>) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(common((List<Integer>) testCases[4][0], (List<Integer>) testCases[4][1]), 
                     find_shared_elements((List<Integer>) testCases[4][0], (List<Integer>) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(common((List<Integer>) testCases[5][0], (List<Integer>) testCases[5][1]), 
                     find_shared_elements((List<Integer>) testCases[5][0], (List<Integer>) testCases[5][1]));
    }
}