import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_146 {

    // Source Code
    static class SourceCode {
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

    // Transformed Code
    static class TransformedCode {
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
    private static final int[][] testCases = {
        {5, 13, 37, 91, 24, 17},       // Expected: 3 (13, 37, 91)
        {11, 13, 15, 17, 19, 21},     // Expected: 6
        {10, 11, 12, 13, 14, 15},     // Expected: 3 (11, 13, 15)
        {22, 24, 26, 28, 30},         // Expected: 0
        {135, 147, 159, 171, 183},     // Expected: 5
        {111, 133, 155, 177, 199},     // Expected: 5
        {3, 5, 7, 9, 10, 20, 30},     // Expected: 0
        {11, 33, 55, 77, 99, 101},    // Expected: 6
        {113, 135, 157, 179, 191, 213},// Expected: 6
        {},                           // Expected: 0
        {11, 12, 13, 14, 15, 16, 17}, // Expected: 4 (11, 13, 15, 17)
        {9, 11, 21, 31, 41, 51},      // Expected: 5 (11, 21, 31, 41, 51)
        {19, 29, 39, 49, 59, 69},     // Expected: 6
        {8, 9, 10},                   // Expected: 0
        {19, 29, 39, 49, 59, 79}      // Expected: 6
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void specialFilter_vs_countSpecialNumbers(int[] inputArray) {
        List<Integer> inputList = Arrays.asList(Arrays.stream(inputArray).boxed().toArray(Integer[]::new));
        assertEquals(
            SourceCode.specialFilter(inputArray),
            TransformedCode.countSpecialNumbers(inputList)
        );
    }
}