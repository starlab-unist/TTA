import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_113 {

    // Source Code
    static class SourceCode {
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
    static class TransformedCode {
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
    private static final Object[][] testCases = {
        {Arrays.asList("12345")},
        {Arrays.asList("24680", "13579")},
        {Arrays.asList("1", "2", "3", "4", "5")},
        {new ArrayList<String>()},
        {Arrays.asList("0", "00", "000")},
        {Arrays.asList("111", "222", "333")},
        {Arrays.asList("135", "79", "2468")},
        {Arrays.asList("987654321")},
        {Arrays.asList("11", "22", "33")},
        {Arrays.asList("00000", "11111", "22222")}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Testing equivalence of oddCount and countOddsInSublists")
    void test_oddCount_vs_countOddsInSublists(List<String> input) {
        SourceCode source = new SourceCode();
        TransformedCode transformed = new TransformedCode();

        assertEquals(
            source.oddCount(input),
            transformed.countOddsInSublists(Arrays.asList(input))
        );
    }
}