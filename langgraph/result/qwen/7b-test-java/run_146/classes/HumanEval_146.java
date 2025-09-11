import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_146 {

    // Source Code
    static class HumanEval_146_Source {
        public static int specialFilter(int[] nums) {
            int count = 0;
            for (int num : nums) {
                if (num > 10) {
                    int[] oddDigits = {1, 3, 5, 7, 9};
                    String numberAsString = Integer.toString(num);
                    int firstDigit = Character.digit(numberAsString.charAt(0), 10);
                    int lastDigit = Character.digit(numberAsString.charAt(numberAsString.length() - 1), 10);
                    boolean isFirstDigitOdd = false;
                    boolean isLastDigitOdd = false;
                    for (int digit : oddDigits) {
                        if (digit == firstDigit) {
                            isFirstDigitOdd = true;
                        }
                        if (digit == lastDigit) {
                            isLastDigitOdd = true;
                        }
                        if (isFirstDigitOdd && isLastDigitOdd) {
                            count++;
                            break;
                        }
                    }
                }
            }
            return count;
        }
    }

    // Transformed Code
    static class HumanEval_146_Transformed {
        public static int countSpecialNumbers(int[] nums) {
            int count = 0;
            java.util.Iterator<Integer> iterator = new java.util.Iterator<>() {
                private int index = 0;

                @Override
                public boolean hasNext() {
                    return index < nums.length;
                }

                @Override
                public Integer next() {
                    return nums[index++];
                }
            };

            while (iterator.hasNext()) {
                int currentNumber = iterator.next();
                if (currentNumber > 10) {
                    java.util.Set<Integer> oddDigitsSet = new java.util.HashSet<>();
                    oddDigitsSet.add(1);
                    oddDigitsSet.add(3);
                    oddDigitsSet.add(5);
                    oddDigitsSet.add(7);
                    oddDigitsSet.add(9);
                    String numStr = String.valueOf(currentNumber);
                    int firstDigit = Character.getNumericValue(numStr.charAt(0));
                    int lastDigit = Character.getNumericValue(numStr.charAt(numStr.length() - 1));
                    if (oddDigitsSet.contains(firstDigit) && oddDigitsSet.contains(lastDigit)) {
                        count++;
                    }
                }
            }

            return count;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {5, 13, 37, 91, 24, 17},
        {11, 13, 15, 17, 19, 21},
        {10, 11, 12, 13, 14, 15},
        {22, 24, 26, 28, 30},
        {135, 147, 159, 171, 183},
        {111, 133, 155, 177, 199},
        {3, 5, 7, 9, 10, 20, 30},
        {11, 33, 55, 77, 99, 101},
        {113, 135, 157, 179, 191, 213},
        {}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_146_Source.specialFilter(testCases[0]), HumanEval_146_Transformed.countSpecialNumbers(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_146_Source.specialFilter(testCases[1]), HumanEval_146_Transformed.countSpecialNumbers(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_146_Source.specialFilter(testCases[2]), HumanEval_146_Transformed.countSpecialNumbers(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_146_Source.specialFilter(testCases[3]), HumanEval_146_Transformed.countSpecialNumbers(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_146_Source.specialFilter(testCases[4]), HumanEval_146_Transformed.countSpecialNumbers(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_146_Source.specialFilter(testCases[5]), HumanEval_146_Transformed.countSpecialNumbers(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_146_Source.specialFilter(testCases[6]), HumanEval_146_Transformed.countSpecialNumbers(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_146_Source.specialFilter(testCases[7]), HumanEval_146_Transformed.countSpecialNumbers(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_146_Source.specialFilter(testCases[8]), HumanEval_146_Transformed.countSpecialNumbers(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_146_Source.specialFilter(testCases[9]), HumanEval_146_Transformed.countSpecialNumbers(testCases[9]));
    }
}