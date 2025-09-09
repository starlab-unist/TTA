import java.util.*;
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
    private static final Integer[][] testCases = {
        {5, 13, 37, 91, 24, 17},       // Original test case
        {11, 13, 15, 17, 19, 21},     // All numbers are valid special numbers
        {10, 11, 12, 13, 14, 15},     // Mixed numbers
        {22, 24, 26, 28, 30},         // No valid special numbers
        {135, 147, 159, 171, 183},   // All numbers are valid special numbers
        {111, 133, 155, 177, 199},   // Repeated pattern of valid special numbers
        {3, 5, 7, 9, 10, 20, 30},     // No numbers greater than 10 are valid special numbers
        {11, 33, 55, 77, 99, 101},    // All numbers are valid special numbers except one
        {113, 135, 157, 179, 191, 213},// Mixed set of numbers with some valid special numbers
        {},                           // Empty array

        // Additional simple value test cases
        {1},                          // Single number less than or equal to 10
        {12, 34, 56, 78, 90},       // No valid special numbers
        {11, 33, 55, 77, 99},         // All numbers are valid special numbers
        {13, 25, 37, 49, 61},         // Mixed set with some valid special numbers
        {0, 2, 4, 6, 8, 10},          // No numbers greater than 10 are valid special numbers
        {15, 35, 55, 75, 95},         // All numbers are valid special numbers
        {19, 29, 39, 49, 59},         // Mixed set with some valid special numbers

        // New simple value test cases
        {21},                         // Single number that is a valid special number
        {22},                         // Single number that is not a valid special number
        {101, 301, 501, 701, 901},   // Numbers with first and last digits odd but middle digit even
        {123, 345, 567, 789, 901},   // Mixed set with some valid special numbers in the middle
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @DisplayName("specialFilter vs countSpecialNumbers")
    @ParameterizedTest(name = "test case {index}")
    @MethodSource("provideTestCases")
    void specialFilter_vs_countSpecialNumbers(Integer[] inputArray) {
        List<Integer> inputList = Arrays.asList(inputArray);

        assertEquals(
            SourceCode.specialFilter(inputArray),
            TransformedCode.countSpecialNumbers(inputList)
        );
    }
}