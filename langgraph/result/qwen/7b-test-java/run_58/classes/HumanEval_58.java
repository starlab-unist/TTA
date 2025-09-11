import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_58 {

    // Source Code
    static class HumanEval_58_Source {
        public List<Integer> common(List<Integer> l1, List<Integer> l2) {
            Set<Integer> ret = new HashSet<>();
            for (Integer e1 : l1) {
                for (Integer e2 : l2) {
                    if (e1.equals(e2)) {
                        ret.add(e1);
                    }
                }
            }
            return List.copyOf(ret.stream().sorted().toList());
        }
    }

    // Transformed Code
    static class HumanEval_58_Transformed {
        public static List<Integer> common(List<Integer> l1, List<Integer> l2) {
            Set<Integer> ret = new HashSet<>();
            Iterator<Integer> iteratorA = l1.iterator();
            
            while (iteratorA.hasNext()) {
                Integer elementA = iteratorA.next();
                for (Integer elementB : l2) {
                    if (elementA.equals(elementB)) {
                        ret.add(elementA);
                    }
                }
            }
            
            return List.copyOf(ret.stream().sorted().toList());
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {List.of(1, 2, 3), List.of(2, 3, 4)},
        {List.of(), List.of()},
        {List.of(10, 20, 30), List.of(40, 50, 60)},
        {List.of(1, 1, 2, 2), List.of(2, 2, 3, 3)},
        {List.of(1, 2, 3, 4, 5), List.of(3, 4, 5, 6, 7)},
        {List.of(), List.of()},
        {List.of(), List.of(1, 2, 3)},
        {List.of(1, 2, 3), List.of()},
    };

    @Test
    public void test_0() {
        assertEquals(new HumanEval_58_Source().common((List<Integer>) testCases[0][0], (List<Integer>) testCases[0][1]), 
                     HumanEval_58_Transformed.common((List<Integer>) testCases[0][0], (List<Integer>) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_58_Source().common((List<Integer>) testCases[1][0], (List<Integer>) testCases[1][1]), 
                     HumanEval_58_Transformed.common((List<Integer>) testCases[1][0], (List<Integer>) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_58_Source().common((List<Integer>) testCases[2][0], (List<Integer>) testCases[2][1]), 
                     HumanEval_58_Transformed.common((List<Integer>) testCases[2][0], (List<Integer>) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_58_Source().common((List<Integer>) testCases[3][0], (List<Integer>) testCases[3][1]), 
                     HumanEval_58_Transformed.common((List<Integer>) testCases[3][0], (List<Integer>) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_58_Source().common((List<Integer>) testCases[4][0], (List<Integer>) testCases[4][1]), 
                     HumanEval_58_Transformed.common((List<Integer>) testCases[4][0], (List<Integer>) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_58_Source().common((List<Integer>) testCases[5][0], (List<Integer>) testCases[5][1]), 
                     HumanEval_58_Transformed.common((List<Integer>) testCases[5][0], (List<Integer>) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_58_Source().common((List<Integer>) testCases[6][0], (List<Integer>) testCases[6][1]), 
                     HumanEval_58_Transformed.common((List<Integer>) testCases[6][0], (List<Integer>) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_58_Source().common((List<Integer>) testCases[7][0], (List<Integer>) testCases[7][1]), 
                     HumanEval_58_Transformed.common((List<Integer>) testCases[7][0], (List<Integer>) testCases[7][1]));
    }
}