import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HumanEval_155 {

    // Source Code
    public static int[] evenOddCount(int num) {
        int evenCount = 0;
        int oddCount = 0;
        String numberStr = Integer.toString(Math.abs(num));
        for (char c : numberStr.toCharArray()) {
            int digit = Character.getNumericValue(c);
            if (digit % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        return new int[]{evenCount, oddCount};
    }

    // Transformed Code
    public static int[] tallyEvenOddDigits(int number) {
        int evenTally = 0;
        int oddTally = 0;
        String numStr = Integer.toString(Math.abs(number));
        
        for (char c : numStr.toCharArray()) {
            int digit = Character.getNumericValue(c);
            if (digit % 2 == 0) {
                evenTally += 1;
            } else {
                oddTally += 1;
            }
        }
        
        return new int[]{evenTally, oddTally};
    }

    // Test Cases
    @Test
    public void test_0() {
        assertArrayEquals(evenOddCount(1234567890), tallyEvenOddDigits(1234567890));
    }
    
    @Test
    public void test_1() {
        assertArrayEquals(evenOddCount(-1234567890), tallyEvenOddDigits(-1234567890));
    }
        
    @Test
    public void test_2() {
        assertArrayEquals(evenOddCount(24680), tallyEvenOddDigits(24680));
    }
    
    @Test
    public void test_3() {
        assertArrayEquals(evenOddCount(13579), tallyEvenOddDigits(13579));
    }
    
    @Test
    public void test_4() {
        assertArrayEquals(evenOddCount(0), tallyEvenOddDigits(0));
    }
        
    @Test
    public void test_5() {
        assertArrayEquals(evenOddCount(111222333444), tallyEvenOddDigits(111222333444));
    }
    
    @Test
    public void test_6() {
        assertArrayEquals(evenOddCount(987654321), tallyEvenOddDigits(987654321));
    }
    
    @Test
    public void test_7() {
        assertArrayEquals(evenOddCount(-987654321), tallyEvenOddDigits(-987654321));
    }
    
    @Test
    public void test_8() {
        assertArrayEquals(evenOddCount(1000000), tallyEvenOddDigits(1000000));
    }
    
    @Test
    public void test_9() {
        assertArrayEquals(evenOddCount(1), tallyEvenOddDigits(1));
    }

    // Additional Simple Test Cases
    @Test
    public void test_10() {
        assertArrayEquals(evenOddCount(2), tallyEvenOddDigits(2)); // Even number only
    }
    
    @Test
    public void test_11() {
        assertArrayEquals(evenOddCount(3), tallyEvenOddDigits(3)); // Odd number only
    }

    @Test
    public void test_12() {
        assertArrayEquals(evenOddCount(10), tallyEvenOddDigits(10)); // Mixed even and odd
    }
    
    @Test
    public void test_13() {
        assertArrayEquals(evenOddCount(-10), tallyEvenOddDigits(-10)); // Negative with mixed digits
    }

    @Test
    public void test_14() {
        assertArrayEquals(evenOddCount(222), tallyEvenOddDigits(222)); // Repeated even digit
    }
    
    @Test
    public void test_15() {
        assertArrayEquals(evenOddCount(333), tallyEvenOddDigits(333)); // Repeated odd digit
    }
}