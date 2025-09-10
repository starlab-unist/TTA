import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections; // Import Collections for sorting
import java.util.List;
import java.util.stream.Stream;  // Import Stream for method source

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_33 {

    // Source Code
    static class SourceCode {
        public static List<Integer> sortThird(List<Integer> l) {
            List<Integer> result = new ArrayList<>(l);
            List<Integer> everyThird = new ArrayList<>();
            
            for (int i = 0; i < result.size(); i += 3) {
                everyThird.add(result.get(i));
            }
            
            Collections.sort(everyThird); // Now this will be recognized
            
            for (int i = 0, j = 0; i < result.size(); i += 3, j++) {
                result.set(i, everyThird.get(j));
            }
            
            return result;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static List<Integer> arrangeEveryThirdElement(List<Integer> inputList) {
            List<Integer> elementsToSort = new ArrayList<>();
            for (int i = 0; i < inputList.size(); i += 3) {
                elementsToSort.add(inputList.get(i));
            }
            Collections.sort(elementsToSort); // Now this will be recognized
            List<Integer> resultList = new ArrayList<>(inputList);
            for (int index = 0; index < elementsToSort.size(); index++) {
                resultList.set(index * 3, elementsToSort.get(index));
            }
            return resultList;
        }
    }

    // Test Cases
    private static final List<List<Integer>> testCases = Arrays.asList(
        Arrays.asList(9, 2, 3, 6, 5, 4, 1, 8, 7),
        Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90),
        Arrays.asList(1, 2, 3),
        Arrays.asList(3, 2, 1, 6, 5, 4, 9, 8, 7),
        new ArrayList<>(),
        Arrays.asList(5),
        Arrays.asList(5, 10),
        Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5),
        Arrays.asList(7, 8, 9, 1, 2, 3, 4, 5, 6),
        Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0)
    );

    private static Stream<Arguments> provideTestCases() {
        return testCases.stream().map(Arguments::of); // Now this will be recognized
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Test sortThird vs arrangeEveryThirdElement")
    void sortThird_vs_arrangeEveryThirdElement(List<Integer> inputList) {
        assertEquals(
            SourceCode.sortThird(inputList),
            TransformedCode.arrangeEveryThirdElement(inputList)
        );
    }
}