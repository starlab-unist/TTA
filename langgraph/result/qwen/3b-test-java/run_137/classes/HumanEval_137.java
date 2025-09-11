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
    public static Double compareOne(Double a, Double b) {
        if (a != null && b != null) {
            if (a.equals(b)) {
                return null;
            }
            return a.compareTo(b) > 0 ? a : b;
        }
        return null;
    }

    // Transformed Code
    public static String evaluateAndCompare(String value1, String value2) {
        String tempA = value1;
        String tempB = value2;

        if (tempA.contains(",")) {
            tempA = tempA.replace(",", ".");
        }
        if (tempB.contains(",")) {
            tempB = tempB.replace(",", ".");
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
        {5.0, 3.0},
        {"4.5", "4.6"},
        {"7,8", "7.8"},
        {"10", 10.0},
        {"123", "123.0"},
        {"1,234", "1.234"},
        {"9.99", 9.990},
        {"5", "5"},
        {"6", 6.0},
        {"7.5", "7,5"}
    };

    @Test
    public void test_0() {
        assertEquals(compareOne((Double) testCases[0][0], (Double) testCases[0][1]), 
                     evaluateAndCompare(testCases[0][0].toString(), testCases[0][1].toString()));
    }

    @Test
    public void test_1() {
        assertEquals(compareOne(Double.parseDouble((String) testCases[1][0]), Double.parseDouble((String) testCases[1][1])), 
                     evaluateAndCompare((String) testCases[1][0], (String) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(compareOne(Double.parseDouble((String) testCases[2][0]), Double.parseDouble(((String) testCases[2][1]).replace(",", "."))), 
                     evaluateAndCompare((String) testCases[2][0], (String) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(compareOne(Double.parseDouble((String) testCases[3][0]), (Double) testCases[3][1]), 
                     evaluateAndCompare((String) testCases[3][0], testCases[3][1].toString()));
    }

    @Test
    public void test_4() {
        assertEquals(compareOne(Double.parseDouble((String) testCases[4][0]), Double.parseDouble((String) testCases[4][1])), 
                     evaluateAndCompare((String) testCases[4][0], (String) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(compareOne(Double.parseDouble(((String) testCases[5][0]).replace(",", ".")), Double.parseDouble((String) testCases[5][1])), 
                     evaluateAndCompare((String) testCases[5][0], (String) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(compareOne(Double.parseDouble((String) testCases[6][0]), Double.parseDouble((String) testCases[6][1])), 
                     evaluateAndCompare((String) testCases[6][0], (String) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(compareOne(Double.parseDouble((String) testCases[7][0]), Double.parseDouble((String) testCases[7][1])), 
                     evaluateAndCompare((String) testCases[7][0], (String) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(compareOne(Double.parseDouble((String) testCases[8][0]), (Double) testCases[8][1]), 
                     evaluateAndCompare((String) testCases[8][0], testCases[8][1].toString()));
    }

    @Test
    public void test_9() {
        assertEquals(compareOne(Double.parseDouble((String) testCases[9][0]), Double.parseDouble(((String) testCases[9][1]).replace(",", "."))), 
                     evaluateAndCompare((String) testCases[9][0], (String) testCases[9][1]));
    }
}