import java.util.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_113 {

    // Source Code
    static class HumanEval_113_Source {
        public List<String> oddCount(List<String> lst) {
            List<String> res = new ArrayList<>();
            for (String arr : lst) {
                int n = 0;
                for (char d : arr.toCharArray()) {
                    if ((d - '0') % 2 == 1) {
                        n++;
                    }
                }
                res.add("the number of odd elements " + n + "n the str" + n + "ng " + n + " of the " + n + "nput.");
            }
            return res;
        }
    }

    // Transformed Code
    static class HumanEval_113_Transformed {
        public List<String> countOddsInSublists(List<List<String>> inputList) {
            List<String> result = new ArrayList<>();
            for (List<String> sublist : inputList) {
                int oddCount = 0;
                for (String digit : sublist) {
                    if (Integer.parseInt(digit) % 2 != 0) {
                        oddCount++;
                    }
                }
                result.add("the number of odd elements " + oddCount + "n the str" + oddCount + "ng " + oddCount + " of the " + oddCount + "nput.");
            }
            return result;
        }
    }

    // Test Cases
    private static final List<Arguments> testCases = Arrays.asList(
        Arguments.of(Arrays.asList("12345")),
        Arguments.of(Arrays.asList("24680", "13579")),
        Arguments.of(Arrays.asList("1", "2", "3", "4", "5")),
        Arguments.of(new ArrayList<>()),
        Arguments.of(Arrays.asList("0", "00", "000")),
        Arguments.of(Arrays.asList("111", "222", "333")),
        Arguments.of(Arrays.asList("135", "79", "2468")),
        Arguments.of(Arrays.asList("987654321")),
        Arguments.of(Arrays.asList("11", "22", "33")),
        Arguments.of(Arrays.asList("00000", "11111", "22222"))
    );

    private static Stream<Arguments> provideTestCases() {
        return testCases.stream();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void oddCount_vs_countOddsInSublists(List<String> input) {
        // Prepare the transformed function's input format
        List<List<String>> transformedInput = new ArrayList<>();
        transformedInput.add(input);

        // Expected result from source function
        List<String> expectedOutput = HumanEval_113_Source.oddCount(input);
        
        // Actual result from transformed function
        List<String> actualOutput = HumanEval_113_Transformed.countOddsInSublists(transformedInput);
        
        assertEquals(expectedOutput, actualOutput);
    }
}