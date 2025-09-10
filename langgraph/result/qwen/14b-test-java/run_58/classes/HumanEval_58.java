import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_58 {

    // Source Code
    private static class SourceCode {
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
    }

    // Transformed Code
    private static class TransformedCode {
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
    }

    private static final Object[][] testCases = {
        {Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 4)}, // Common: [2, 3]
        {Arrays.asList(10, 20, 30), Arrays.asList(40, 50, 60)}, // Common: []
        {Arrays.asList(), Arrays.asList()}, // Common: []
        {Arrays.asList(1, 1, 2, 2), Arrays.asList(2, 2, 3, 3)}, // Common: [2]
        {Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(3, 4, 5, 6, 7)}, // Common: [3, 4, 5]
        {Arrays.asList(100, 200, 300), Arrays.asList(100, 200, 300)}, // Common: [100, 200, 300]
        {Arrays.asList(5, 10, 15), Arrays.asList(15, 10, 5)}, // Common: [5, 10, 15]
        {Arrays.asList(7, 8, 9), Arrays.asList()}, // Common: []
        {Arrays.asList(), Arrays.asList(1, 2, 3)}, // Common: []
        {Arrays.asList(4, 8, 12), Arrays.asList(2, 4, 6, 8)} // Common: [4, 8]
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void common_vs_find_shared_elements(List<Integer> list1, List<Integer> list2) {
        assertEquals(
            SourceCode.common(list1, list2),
            TransformedCode.find_shared_elements(list1, list2)
        );
    }
}