import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_104 {

    // Source Code
    static class HumanEval_104_Source {
        public static ArrayList<Integer> uniqueDigits(int x) {
            ArrayList<Integer> oddDigitElements = new ArrayList<>();
            String numberStr = Integer.toString(x);
            for (char digitChar : numberStr.toCharArray()) {
                int digit = Character.getNumericValue(digitChar);
                if (digit % 2 != 0) {
                    oddDigitElements.add(digit);
                }
            }
            Collections.sort(oddDigitElements);
            return oddDigitElements;
        }
    }

    // Transformed Code
    static class HumanEval_104_Transformed {
        public static List<Integer> filterOddDigitNumbers(List<Integer> numbers) {
            List<Integer> oddDigitNumbers = new ArrayList<>();
            
            for (int number : numbers) {
                String numStr = Integer.toString(number);
                boolean hasOddDigit = true;
                
                for (char c : numStr.toCharArray()) {
                    int digit = Character.getNumericValue(c);
                    if (digit % 2 == 0) {
                        hasOddDigit = false;
                        break;
                    }
                }
                
                if (hasOddDigit) {
                    oddDigitNumbers.add(number);
                }
            }
            
            oddDigitNumbers.sort(Integer::compareTo);
            return oddDigitNumbers;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(135, 246, 357, 579), Arrays.asList(1, 3, 5)},
        {Arrays.asList(111, 333, 555, 777, 999), Arrays.asList(1, 3, 5, 7, 9)},
        {Arrays.asList(222, 444, 666, 888), new ArrayList<Integer>()},
        {Arrays.asList(13579, 2468, 12345), Arrays.asList(1, 3, 5, 7, 9)},
        {Arrays.asList(1, 3, 5, 7, 9), Arrays.asList(1, 3, 5, 7, 9)},
        {Arrays.asList(0, 2, 4, 6, 8), new ArrayList<Integer>()},
        {Arrays.asList(135, 579, 791, 913), Arrays.asList(1, 3, 5, 7, 9)},
        {new ArrayList<Integer>(), new ArrayList<Integer>()},
        {Arrays.asList(113, 135, 357, 579), Arrays.asList(1, 3, 5, 7, 9)},
        {Arrays.asList(123, 321, 213, 456), Arrays.asList(1, 3)}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_104_Source.uniqueDigits(((List<Integer>) testCases[0][0]).get(0)), 
                     HumanEval_104_Transformed.filterOddDigitNumbers((List<Integer>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_104_Source.uniqueDigits(((List<Integer>) testCases[1][0]).get(0)), 
                     HumanEval_104_Transformed.filterOddDigitNumbers((List<Integer>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_104_Source.uniqueDigits(((List<Integer>) testCases[2][0]).get(0)), 
                     HumanEval_104_Transformed.filterOddDigitNumbers((List<Integer>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_104_Source.uniqueDigits(((List<Integer>) testCases[3][0]).get(0)), 
                     HumanEval_104_Transformed.filterOddDigitNumbers((List<Integer>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_104_Source.uniqueDigits(((List<Integer>) testCases[4][0]).get(0)), 
                     HumanEval_104_Transformed.filterOddDigitNumbers((List<Integer>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_104_Source.uniqueDigits(((List<Integer>) testCases[5][0]).get(0)), 
                     HumanEval_104_Transformed.filterOddDigitNumbers((List<Integer>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_104_Source.uniqueDigits(((List<Integer>) testCases[6][0]).get(0)), 
                     HumanEval_104_Transformed.filterOddDigitNumbers((List<Integer>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_104_Source.uniqueDigits(((List<Integer>) testCases[7][0]).get(0)), 
                     HumanEval_104_Transformed.filterOddDigitNumbers((List<Integer>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_104_Source.uniqueDigits(((List<Integer>) testCases[8][0]).get(0)), 
                     HumanEval_104_Transformed.filterOddDigitNumbers((List<Integer>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_104_Source.uniqueDigits(((List<Integer>) testCases[9][0]).get(0)), 
                     HumanEval_104_Transformed.filterOddDigitNumbers((List<Integer>) testCases[9][0]));
    }
}