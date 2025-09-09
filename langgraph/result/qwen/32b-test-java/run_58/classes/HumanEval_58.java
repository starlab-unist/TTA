import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;
import java.util.Arrays;

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
        {List.of(1, 2, 3), List.of(2, 3, 4)}, // Common elements: [2, 3]
        {List.of(), List.of()},               // No elements, common: []
        {List.of(10, 20, 30), List.of(40, 50, 60)}, // No common elements: []
        {List.of(1, 1, 2, 2), List.of(2, 2, 3, 3)},   // Common elements: [2]
        {List.of(), List.of(1, 2, 3)},       // One list empty, common: []
        {List.of(1, 2, 3), List.of()},       // One list empty, common: []
        {List.of(1, 2, 3, 4, 5), List.of(3, 4, 5, 6, 7)}, // Common elements: [3, 4, 5]
        {List.of(1, 2, 3), List.of(1, 2, 3)},   // Identical lists, common: [1, 2, 3]
        {List.of(5), List.of(5)},             // Single element, common: [5]
        {List.of(5), List.of()},               // Single element vs empty list, common: []
        {List.of(-1, -2, -3), List.of(-2, -3, -4)}, // Common elements: [-3, -2]
        {List.of(0, 0, 0), List.of(0, 0, 0)},   // Identical lists with duplicates, common: [0]
        {List.of(100), List.of(100, 200, 300)},// Common elements: [100]
        {List.of(1, 3, 5, 7, 9), List.of(2, 4, 6, 8, 10)}, // No common elements: []
        {List.of(10, 20, 30), List.of(30, 20, 10)} // Common elements: [10, 20, 30] (unordered input)
    };

    private static java.util.stream.Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Compare common elements of two lists using original and transformed functions")
    void common_vs_findSharedElements(List<Integer> list1, List<Integer> list2) {
        assertEquals(
            new SourceCode().common(list1, list2),
            new TransformedCode().findSharedElements(list1, list2)
        );
    }
}