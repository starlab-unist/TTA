import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Source Code
class OriginalImpl {
    public List<String> byLength(List<Integer> arr) {
        Map<Integer, String> dic = new HashMap<>();
        dic.put(1, "One");
        dic.put(2, "Two");
        dic.put(3, "Three");
        dic.put(4, "Four");
        dic.put(5, "Five");
        dic.put(6, "Six");
        dic.put(7, "Seven");
        dic.put(8, "Eight");
        dic.put(9, "Nine");

        List<Integer> sortedArr = new ArrayList<>(arr);
        Collections.sort(sortedArr, Collections.reverseOrder());

        List<String> newArr = new ArrayList<>();
        for (Integer var : sortedArr) {
            if (dic.containsKey(var)) {
                newArr.add(dic.get(var));
            }
        }
        return newArr;
    }
}

// Transformed Code
class TransformedImpl {

    public List<String> arrangeByNumberName(List<Integer> numbers) {
        Map<Integer, String> numberNames = new HashMap<>();
        numberNames.put(1, "One");
        numberNames.put(2, "Two");
        numberNames.put(3, "Three");
        numberNames.put(4, "Four");
        numberNames.put(5, "Five");
        numberNames.put(6, "Six");
        numberNames.put(7, "Seven");
        numberNames.put(8, "Eight");
        numberNames.put(9, "Nine");

        List<Integer> descendingNumbers = new ArrayList<>(numbers);
        Collections.sort(descendingNumbers, Comparator.reverseOrder());

        List<String> namedNumbers = new ArrayList<>();
        int index = 0;
        while (index < descendingNumbers.size()) {
            int num = descendingNumbers.get(index);
            if (numberNames.containsKey(num)) {
                namedNumbers.add(numberNames.get(num));
            }
            index++;
        }
        return namedNumbers;
    }
}

// Test Cases
public class HumanEval_105 {

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.arguments(Arrays.asList(3, 2, 1)),
            Arguments.arguments(Arrays.asList(9, 8, 7, 6, 5)),
            Arguments.arguments(Arrays.asList(4, 4, 4, 4)),
            Arguments.arguments(Arrays.asList(10, 11, 12)),  // should return empty as none are in the dictionary
            Arguments.arguments(Arrays.asList()),
            Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)),
            Arguments.arguments(Arrays.asList(9, 3, 5, 7, 1)),
            Arguments.arguments(Arrays.asList(2, 2, 2, 3, 3, 1)),
            Arguments.arguments(Arrays.asList(5)),  // single element
            Arguments.arguments(Arrays.asList(0, -1, 10))   // should return empty as none are in the dictionary
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void test(List<Integer> input) {
        assertEquals(new OriginalImpl().byLength(input), 
                     new TransformedImpl().arrangeByNumberName(input));
    }
}