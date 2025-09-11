import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_131 {

    // Source Code
    static class HumanEval_131_Source {
        public static int digits(int n) {
            int product = 1;
            int oddCount = 0;
            String numberStr = Integer.toString(n);
            
            for (char digitChar : numberStr.toCharArray()) {
                int intDigit = Character.getNumericValue(digitChar);
                if (intDigit % 2 == 1) {
                    product *= intDigit;
                    oddCount++;
                }
            }
            
            if (oddCount == 0) {
                return 0;
            } else {
                return product;
            }
        }
    }

    // Transformed Code
    static class HumanEval_131_Transformed {
        public int calculateOddDigitProduct(int number) {
            int result = 1;
            int oddDigitsFound = 0;
            String numberStr = Integer.toString(number);
            
            for (int i = 0; i < numberStr.length(); i++) {
                int currentDigit = Character.getNumericValue(numberStr.charAt(i));
                if (currentDigit % 2 != 0) {
                    result *= currentDigit;
                    oddDigitsFound++;
                }
            }
            
            return oddDigitsFound > 0 ? result : 0;
        }
    }

    // Test Cases
    private static final int[] testCases = {
        123456789,
        2468,
        13579,
        11111,
        0,
        987654321,
        2222222,
        123,
        555555,
        9
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_131_Source.digits(testCases[0]), 
                     new HumanEval_131_Transformed().calculateOddDigitProduct(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_131_Source.digits(testCases[1]), 
                     new HumanEval_131_Transformed().calculateOddDigitProduct(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_131_Source.digits(testCases[2]), 
                     new HumanEval_131_Transformed().calculateOddDigitProduct(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_131_Source.digits(testCases[3]), 
                     new HumanEval_131_Transformed().calculateOddDigitProduct(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_131_Source.digits(testCases[4]), 
                     new HumanEval_131_Transformed().calculateOddDigitProduct(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_131_Source.digits(testCases[5]), 
                     new HumanEval_131_Transformed().calculateOddDigitProduct(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_131_Source.digits(testCases[6]), 
                     new HumanEval_131_Transformed().calculateOddDigitProduct(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_131_Source.digits(testCases[7]), 
                     new HumanEval_131_Transformed().calculateOddDigitProduct(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_131_Source.digits(testCases[8]), 
                     new HumanEval_131_Transformed().calculateOddDigitProduct(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_131_Source.digits(testCases[9]), 
                     new HumanEval_131_Transformed().calculateOddDigitProduct(testCases[9]));
    }
}