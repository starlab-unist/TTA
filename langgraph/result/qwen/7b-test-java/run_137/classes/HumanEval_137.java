import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_137 {

    // Source Code
    public static Object compareOne(Object a, Object b) {
        String tempA = a.toString();
        String tempB = b.toString();

        if (tempA.contains(",")) tempA = tempA.replace(',', '.');
        if (tempB.contains(",")) tempB = tempB.replace(',', '.');

        double numA = Double.parseDouble(tempA);
        double numB = Double.parseDouble(tempB);

        if (numA == numB) return null;
        return numA > numB ? a : b;
    }

    // Transformed Code
    public String evaluateAndCompare(String value1, String value2) {
        String tempA = value1;
        String tempB = value2;

        if (tempA.contains(",")) {
            tempA = tempA.replace(',', '.');
        }
        if (tempB.contains(",")) {
            tempB = tempB.replace(',', '.');
        }

        double numericVal1 = Double.parseDouble(tempA);
        double numericVal2 = Double.parseDouble(tempB);

        if (numericVal1 == numericVal2) {
            return null;
        } else if (numericVal1 > numericVal2) {
            return value1;
        } else {
            return value2;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {5, 3},
        {"4.5", "4.6"},
        {"7,8", "7.8"},
        {"10", 10},
        {"123", "123.0"},
        {"1,234", "1.234"},
        {"9.99", 9.990},
        {"5", "5"},
        {"6", 6},
        {"7.5", "7,5"}
    };

    @Test
    public void test_0() {
        assertEquals(compareOne(testCases[0][0], testCases[0][1]), 
                     evaluateAndCompare(testCases[0][0].toString(), testCases[0][1].toString()));
    }

    @Test
    public void test_1() {
        assertEquals(compareOne(testCases[1][0], testCases[1][1]), 
                     evaluateAndCompare(testCases[1][0].toString(), testCases[1][1].toString()));
    }

    @Test
    public void test_2() {
        assertEquals(compareOne(testCases[2][0], testCases[2][1]), 
                     evaluateAndCompare(testCases[2][0].toString(), testCases[2][1].toString()));
    }

    @Test
    public void test_3() {
        assertEquals(compareOne(testCases[3][0], testCases[3][1]), 
                     evaluateAndCompare(testCases[3][0].toString(), testCases[3][1].toString()));
    }

    @Test
    public void test_4() {
        assertEquals(compareOne(testCases[4][0], testCases[4][1]), 
                     evaluateAndCompare(testCases[4][0].toString(), testCases[4][1].toString()));
    }

    @Test
    public void test_5() {
        assertEquals(compareOne(testCases[5][0], testCases[5][1]), 
                     evaluateAndCompare(testCases[5][0].toString(), testCases[5][1].toString()));
    }

    @Test
    public void test_6() {
        assertEquals(compareOne(testCases[6][0], testCases[6][1]), 
                     evaluateAndCompare(testCases[6][0].toString(), testCases[6][1].toString()));
    }

    @Test
    public void test_7() {
        assertEquals(compareOne(testCases[7][0], testCases[7][1]), 
                     evaluateAndCompare(testCases[7][0].toString(), testCases[7][1].toString()));
    }

    @Test
    public void test_8() {
        assertEquals(compareOne(testCases[8][0], testCases[8][1]), 
                     evaluateAndCompare(testCases[8][0].toString(), testCases[8][1].toString()));
    }

    @Test
    public void test_9() {
        assertEquals(compareOne(testCases[9][0], testCases[9][1]), 
                     evaluateAndCompare(testCases[9][0].toString(), testCases[9][1].toString()));
    }
}