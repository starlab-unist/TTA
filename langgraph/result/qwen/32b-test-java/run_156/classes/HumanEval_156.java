import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_156 {

    // Source Code
    static class HumanEval_156_Source {
        public static String intToMiniRoman(int number) {
            int[] num = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
            String[] sym = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
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
    }

    // Transformed Code
    static class HumanEval_156_Transformed {
        public String convertIntegerToMinimalRoman(int value) {
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
    }

    // Test Cases
    @Test
    public void test_0() {
        assertEquals(HumanEval_156_Source.intToMiniRoman(1), HumanEval_156_Transformed.convertIntegerToMinimalRoman(1));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_156_Source.intToMiniRoman(4), HumanEval_156_Transformed.convertIntegerToMinimalRoman(4));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_156_Source.intToMiniRoman(9), HumanEval_156_Transformed.convertIntegerToMinimalRoman(9));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_156_Source.intToMiniRoman(58), HumanEval_156_Transformed.convertIntegerToMinimalRoman(58));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_156_Source.intToMiniRoman(1994), HumanEval_156_Transformed.convertIntegerToMinimalRoman(1994));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_156_Source.intToMiniRoman(3999), HumanEval_156_Transformed.convertIntegerToMinimalRoman(3999));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_156_Source.intToMiniRoman(1000), HumanEval_156_Transformed.convertIntegerToMinimalRoman(1000));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_156_Source.intToMiniRoman(500), HumanEval_156_Transformed.convertIntegerToMinimalRoman(500));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_156_Source.intToMiniRoman(100), HumanEval_156_Transformed.convertIntegerToMinimalRoman(100));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_156_Source.intToMiniRoman(10), HumanEval_156_Transformed.convertIntegerToMinimalRoman(10));
    }

    // Additional Test Cases for Comprehensive Coverage
    @Test
    public void test_10() {
        assertEquals(HumanEval_156_Source.intToMiniRoman(2), HumanEval_156_Transformed.convertIntegerToMinimalRoman(2));
    }

    @Test
    public void test_11() {
        assertEquals(HumanEval_156_Source.intToMiniRoman(3), HumanEval_156_Transformed.convertIntegerToMinimalRoman(3));
    }

    @Test
    public void test_12() {
        assertEquals(HumanEval_156_Source.intToMiniRoman(40), HumanEval_156_Transformed.convertIntegerToMinimalRoman(40));
    }

    @Test
    public void test_13() {
        assertEquals(HumanEval_156_Source.intToMiniRoman(90), HumanEval_156_Transformed.convertIntegerToMinimalRoman(90));
    }

    @Test
    public void test_14() {
        assertEquals(HumanEval_156_Source.intToMiniRoman(400), HumanEval_156_Transformed.convertIntegerToMinimalRoman(400));
    }
}