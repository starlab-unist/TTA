import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Source Code
class HumanEval_146 {

    // Nested class for the original implementation
    public static class OriginalImpl {
        public static int specialFilter(int[] nums) {
            int count = 0;
            for (int num : nums) {
                if (num > 10) {
                    String numberAsString = Integer.toString(num);
                    int firstDigit = Character.getNumericValue(numberAsString.charAt(0));
                    int lastDigit = Character.getNumericValue(numberAsString.charAt(numberAsString.length() - 1));
                    if ((firstDigit == 1 || firstDigit == 3 || firstDigit == 5 || firstDigit == 7 || firstDigit == 9) &&
                        (lastDigit == 1 || lastDigit == 3 || lastDigit == 5 || lastDigit == 7 || lastDigit == 9)) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    // Nested class for the transformed implementation
    public static class TransformedImpl {
        import java.util.Iterator; // Move imports to top of file, outside any class definition
        import java.util.List;
        import java.util.Set;
        import java.util.HashSet;

        public static int countSpecialNumbers(List<Integer> numbers) {
            int total = 0;
            Iterator<Integer> iterator = numbers.iterator();
            while (iterator.hasNext()) {
                int currentNumber = iterator.next();
                if (currentNumber > 10) {
                    Set<Integer> oddDigitsSet = Set.of(1, 3, 5, 7, 9);
                    String numStr = Integer.toString(currentNumber);
                    if (oddDigitsSet.contains(Character.getNumericValue(numStr.charAt(0))) 
                            && oddDigitsSet.contains(Character.getNumericValue(numStr.charAt(numStr.length() - 1)))) {
                        total += 1;
                    }
                }
            }
            return total;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.arguments(new int[]{5, 13, 37, 91, 24, 17}, Arrays.asList(5, 13, 37, 91, 24, 17)),
            Arguments.arguments(new int[]{11, 13, 15, 17, 19, 21}, Arrays.asList(11, 13, 15, 17, 19, 21)),
            Arguments.arguments(new int[]{10, 11, 12, 13, 14, 15}, Arrays.asList(10, 11, 12, 13, 14, 15)),
            Arguments.arguments(new int[]{22, 24, 26, 28, 30}, Arrays.asList(22, 24, 26, 28, 30)),
            Arguments.arguments(new int[]{135, 147, 159, 171, 183}, Arrays.asList(135, 147, 159, 171, 183)),
            Arguments.arguments(new int[]{111, 133, 155, 177, 199}, Arrays.asList(111, 133, 155, 177, 199)),
            Arguments.arguments(new int[]{3, 5, 7, 9, 10, 20, 30}, Arrays.asList(3, 5, 7, 9, 10, 20, 30)),
            Arguments.arguments(new int[]{11, 33, 55, 77, 99, 101}, Arrays.asList(11, 33, 55, 77, 99, 101)),
            Arguments.arguments(new int[]{113, 135, 157, 179, 191, 213}, Arrays.asList(113, 135, 157, 179, 191, 213)),
            Arguments.arguments(new int[]{}, Arrays.asList())
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testSpecialFilterAndCountSpecialNumbers(int[] inputArray, List<Integer> inputList) {
        assertEquals(OriginalImpl.specialFilter(inputArray), TransformedImpl.countSpecialNumbers(inputList));
    }
}