import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_146 {

    // Source Code
    public static int specialFilter(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num > 10) {
                int[] oddDigits = {1, 3, 5, 7, 9};
                String numberAsString = Integer.toString(num);
                int firstDigit = Character.getNumericValue(numberAsString.charAt(0));
                int lastDigit = Character.getNumericValue(numberAsString.charAt(numberAsString.length() - 1));
                boolean isFirstDigitOdd = false;
                boolean isLastDigitOdd = false;
                
                for (int oddDigit : oddDigits) {
                    if (firstDigit == oddDigit) {
                        isFirstDigitOdd = true;
                    }
                    if (lastDigit == oddDigit) {
                        isLastDigitOdd = true;
                    }
                }
                
                if (isFirstDigitOdd && isLastDigitOdd) {
                    count++;
                }
            }
        }
        return count;
    }

    // Transformed Code
    public static int countSpecialNumbers(int[] numbers) {
        
        int total = 0;
        Iterator<Integer> iterator = new Iterator<>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < numbers.length;
            }
            @Override
            public Integer next() {
                return numbers[index++];
            }
        };
        
        while (true) {
            try {
                int currentNumber = iterator.next();
                if (currentNumber > 10) {
                    Set<Integer> oddDigitsSet = new HashSet<>();
                    oddDigitsSet.add(1);
                    oddDigitsSet.add(3);
                    oddDigitsSet.add(5);
                    oddDigitsSet.add(7);
                    oddDigitsSet.add(9);
                    String numStr = String.valueOf(currentNumber);
                    if (oddDigitsSet.contains(Integer.parseInt(String.valueOf(numStr.charAt(0)))) && 
                        oddDigitsSet.contains(Integer.parseInt(String.valueOf(numStr.charAt(numStr.length() - 1))))) {
                        total++;
                    }
                }
            } catch (Exception e) {
                break;
            }
        }
        
        return total;
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
        assertEquals(specialFilter(testCases[0]), countSpecialNumbers(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(specialFilter(testCases[1]), countSpecialNumbers(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(specialFilter(testCases[2]), countSpecialNumbers(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(specialFilter(testCases[3]), countSpecialNumbers(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(specialFilter(testCases[4]), countSpecialNumbers(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(specialFilter(testCases[5]), countSpecialNumbers(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(specialFilter(testCases[6]), countSpecialNumbers(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(specialFilter(testCases[7]), countSpecialNumbers(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(specialFilter(testCases[8]), countSpecialNumbers(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(specialFilter(testCases[9]), countSpecialNumbers(testCases[9]));
    }
}