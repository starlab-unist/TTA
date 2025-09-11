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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;

// Source Code
class HumanEval_58_Source {
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
class HumanEval_58_Transformed {
    public List<Integer> findSharedElements(List<Integer> listA, List<Integer> listB) {
        Set<Integer> sharedItems = new HashSet<>();
        for (Integer elementA : listA) {
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
public class HumanEval_58 {

    static class OriginalImpl {
        public static List<Integer> common(List<Integer> l1, List<Integer> l2) {
            return new HumanEval_58_Source().common(l1, l2);
        }
    }

    static class TransformedImpl {
        public static List<Integer> findSharedElements(List<Integer> listA, List<Integer> listB) {
            return new HumanEval_58_Transformed().findSharedElements(listA, listB);
        }
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 3), List.of(2, 3, 4)),
            Arguments.of(List.of(), List.of()),
            Arguments.of(List.of(10, 20, 30), List.of(40, 50, 60)),
            Arguments.of(List.of(1, 1, 2, 2), List.of(2, 2, 3, 3)),
            Arguments.of(List.of(5, 10, 15), List.of(10, 15, 20)),
            Arguments.of(List.of(7, 8, 9), List.of(10, 11, 12)),
            Arguments.of(List.of(), List.of()),
            Arguments.of(List.of(1, 3, 5, 7), List.of(2, 4, 6, 8)),
            Arguments.of(List.of(1, 2, 3, 4, 5), List.of(3, 4, 5, 6, 7)),
            Arguments.of(List.of(9, 8, 7), List.of(7, 8, 9))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testCommonAndFindSharedElements(List<Integer> listA, List<Integer> listB) {
        assertEquals(
            OriginalImpl.common(listA, listB), 
            TransformedImpl.findSharedElements(listA, listB)
        );
    }
}