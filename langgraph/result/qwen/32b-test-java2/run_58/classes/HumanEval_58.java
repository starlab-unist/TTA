import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_58 {

    // Source Code
    static class SourceCode {
        public List<Integer> common(List<Integer> l1, List<Integer> l2) {
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
    static class TransformedCode {
        public List<Integer> findSharedElements(List<Integer> listA, List<Integer> listB) {
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
            
            List<Integer> result = new ArrayList<>(sharedItems);
            Collections.sort(result);
            return result;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 4)},
        {Arrays.asList('a', 'b', 'c'), Arrays.asList('b', 'c', 'd')},
        {Arrays.asList(10, 20, 30), Arrays.asList(40, 50, 60)},
        {Arrays.asList(), Arrays.asList()},
        {Arrays.asList(1, 1, 2, 2), Arrays.asList(2, 2, 3, 3)},
        {Arrays.asList("apple", "banana"), Arrays.asList("banana", "orange")},
        {Arrays.asList(true, false), Arrays.asList(false, true)},
        {Arrays.asList('x', 'y', 'z'), Arrays.asList('a', 'b', 'c')},
        {Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(3, 4, 5, 6, 7)},
        {Arrays.asList(null, null, null), Arrays.asList(null)}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void common_vs_findSharedElements(List<Integer> list1, List<Integer> list2) {
        assertEquals(
            SourceCode.common(list1, list2),
            TransformedCode.findSharedElements(list1, list2)
        );
    }
}