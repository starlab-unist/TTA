import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

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
    static class TransformedCode {
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
        {List.of(9, 2, 3, 6, 5, 4, 1, 8, 7)},
        {List.of(10, 20, 30, 40, 50, 60, 70, 80, 90)},
        {List.of(1, 2, 3)},
        {List.of(3, 2, 1, 6, 5, 4, 9, 8, 7)},
        {List.of()},
        {List.of(5)},
        {List.of(5, 10)},
        {List.of(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5)},
        {List.of(7, 8, 9, 1, 2, 3, 4, 5, 6)},
        {List.of(0, 0, 0, 0, 0, 0, 0, 0, 0)}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(arr -> Arguments.of((List<Integer>) arr[0]));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void sortThird_vs_arrangeEveryThirdElement(List<Integer> inputList) {
        assertEquals(
            SourceCode.sortThird(inputList),
            TransformedCode.arrangeEveryThirdElement(inputList)
        );
    }
}