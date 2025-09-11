import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_156 {

    // Source Code
    public static String intToMiniRoman(int number) {
        int[] num = {1, 4, 5, 9, 10, 40, 50, 90,
                100, 400, 500, 900, 1000};
        String[] sym = {"I", "IV", "V", "IX", "X", "XL",
                "L", "XC", "C", "CD", "D", "CM", "M"};
        int i = 12;
        StringBuilder res = new StringBuilder();
        while (number > 0) {
            int div = number / num[i];
            number %= num[i];
            while (div > 0) {
                res.append(sym[i]);
                div--;
            }
            i--;
        }
        return res.toString().toLowerCase();
    }

    // Transformed Code
    public static String convertIntegerToMinimalRoman(int value) {
        int[] numeralValues = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] romanSymbols = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int index = numeralValues.length - 1;
        StringBuilder result = new StringBuilder();

        while (value > 0) {
            int quotient = value / numeralValues[index];
            value %= numeralValues[index];

            while (quotient > 0) {
                result.append(romanSymbols[index]);
                quotient--;
            }

            index--;
        }

        return result.toString().toLowerCase();
    }

    // Test Cases
    private static final Object[][] testCases = {
        {1, "i"},
        {4, "iv"},
        {9, "ix"},
        {58, "lviii"},
        {1994, "mcmxciv"},
        {3999, "mmmcmxcix"},
        {1000, "m"},
        {500, "d"},
        {100, "c"},
        {10, "x"}
    };

    @Test
    public void test_0() {
        assertEquals(intToMiniRoman((int) testCases[0][0]), convertIntegerToMinimalRoman((int) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(intToMiniRoman((int) testCases[1][0]), convertIntegerToMinimalRoman((int) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(intToMiniRoman((int) testCases[2][0]), convertIntegerToMinimalRoman((int) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(intToMiniRoman((int) testCases[3][0]), convertIntegerToMinimalRoman((int) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(intToMiniRoman((int) testCases[4][0]), convertIntegerToMinimalRoman((int) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(intToMiniRoman((int) testCases[5][0]), convertIntegerToMinimalRoman((int) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(intToMiniRoman((int) testCases[6][0]), convertIntegerToMinimalRoman((int) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(intToMiniRoman((int) testCases[7][0]), convertIntegerToMinimalRoman((int) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(intToMiniRoman((int) testCases[8][0]), convertIntegerToMinimalRoman((int) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(intToMiniRoman((int) testCases[9][0]), convertIntegerToMinimalRoman((int) testCases[9][0]));
    }
}