import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Source Code
class HumanEval_113 {

    static class OriginalImpl {
        public static List<String> oddCount(List<String> lst) {
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
    static class TransformedImpl {
        public static List<String> countOddsInSublists(List<String> inputList) {
            List<String> result = new ArrayList<>();
            for (String digit : inputList) {
                int oddCount = 0;
                for (char c : digit.toCharArray()) {
                    if ((c - '0') % 2 != 0) {
                        oddCount++;
                    }
                }
                result.add("the number of odd elements " + oddCount + "n the str" + oddCount + "ng " + oddCount + " of the " + oddCount + "nput.");
            }
            return result;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(Arrays.asList("12345")),
            Arguments.of(Arrays.asList("24680", "13579")),
            Arguments.of(Arrays.asList("1", "2", "3", "4", "5")),
            Arguments.of(Arrays.asList()),
            Arguments.of(Arrays.asList("0", "00", "000")),
            Arguments.of(Arrays.asList("111", "222", "333")),
            Arguments.of(Arrays.asList("135", "79", "2468")),
            Arguments.of(Arrays.asList("987654321")),
            Arguments.of(Arrays.asList("11", "22", "33")),
            Arguments.of(Arrays.asList("00000", "11111", "22222"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void test(List<String> input) {
        assertEquals(OriginalImpl.oddCount(input), TransformedImpl.countOddsInSublists(input));
    }
}