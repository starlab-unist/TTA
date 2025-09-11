import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_104 {

    // Source Code
    static class HumanEval_104_Source {
        public static List<Integer> uniqueDigits(List<Integer> x) {
            List<Integer> oddDigitElements = new ArrayList<>();
            for (Integer i : x) {
                boolean allOdd = true;
                for (char c : String.valueOf(i).toCharArray()) {
                    if ((c - '0') % 2 == 0) {
                        allOdd = false;
                        break;
                    }
                }
                if (allOdd) {
                    oddDigitElements.add(i);
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
            Iterator<Integer> iterator = numbers.iterator();
            
            while (iterator.hasNext()) {
                Integer number = iterator.next();
                boolean allOddDigits = true;
                for (char digit : String.valueOf(number).toCharArray()) {
                    if ((digit - '0') % 2 == 0) {
                        allOddDigits = false;
                        break;
                    }
                }
                if (allOddDigits) {
                    oddDigitNumbers.add(number);
                }
            }
            
            Collections.sort(oddDigitNumbers);
            return oddDigitNumbers;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {List.of(135, 246, 357, 579), List.of(135, 357, 579)},
        {List.of(111, 333, 555, 777, 999), List.of(111, 333, 555, 777, 999)},
        {List.of(222, 444, 666, 888), List.of()},
        {List.of(13579, 2468, 12345), List.of(13579)},
        {List.of(1, 3, 5, 7, 9), List.of(1, 3, 5, 7, 9)},
        {List.of(0, 2, 4, 6, 8), List.of()},
        {List.of(135, 579, 791, 913), List.of(135, 579, 791, 913)},
        {List.of(), List.of()},
        {List.of(113, 135, 357, 579), List.of(113, 135, 357, 579)},
        {List.of(123, 321, 213, 456), List.of()}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_104_Source.uniqueDigits((List<Integer>) testCases[0][0]), 
                     HumanEval_104_Transformed.filterOddDigitNumbers((List<Integer>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_104_Source.uniqueDigits((List<Integer>) testCases[1][0]), 
                     HumanEval_104_Transformed.filterOddDigitNumbers((List<Integer>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_104_Source.uniqueDigits((List<Integer>) testCases[2][0]), 
                     HumanEval_104_Transformed.filterOddDigitNumbers((List<Integer>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_104_Source.uniqueDigits((List<Integer>) testCases[3][0]), 
                     HumanEval_104_Transformed.filterOddDigitNumbers((List<Integer>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_104_Source.uniqueDigits((List<Integer>) testCases[4][0]), 
                     HumanEval_104_Transformed.filterOddDigitNumbers((List<Integer>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_104_Source.uniqueDigits((List<Integer>) testCases[5][0]), 
                     HumanEval_104_Transformed.filterOddDigitNumbers((List<Integer>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_104_Source.uniqueDigits((List<Integer>) testCases[6][0]), 
                     HumanEval_104_Transformed.filterOddDigitNumbers((List<Integer>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_104_Source.uniqueDigits((List<Integer>) testCases[7][0]), 
                     HumanEval_104_Transformed.filterOddDigitNumbers((List<Integer>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_104_Source.uniqueDigits((List<Integer>) testCases[8][0]), 
                     HumanEval_104_Transformed.filterOddDigitNumbers((List<Integer>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_104_Source.uniqueDigits((List<Integer>) testCases[9][0]), 
                     HumanEval_104_Transformed.filterOddDigitNumbers((List<Integer>) testCases[9][0]));
    }
}