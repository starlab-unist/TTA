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

    // Transformed Code
    public static int calculate_odd_digit_product(int number) {
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
        assertEquals(digits(testCases[0]), calculate_odd_digit_product(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(digits(testCases[1]), calculate_odd_digit_product(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(digits(testCases[2]), calculate_odd_digit_product(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(digits(testCases[3]), calculate_odd_digit_product(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(digits(testCases[4]), calculate_odd_digit_product(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(digits(testCases[5]), calculate_odd_digit_product(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(digits(testCases[6]), calculate_odd_digit_product(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(digits(testCases[7]), calculate_odd_digit_product(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(digits(testCases[8]), calculate_odd_digit_product(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(digits(testCases[9]), calculate_odd_digit_product(testCases[9]));
    }
}