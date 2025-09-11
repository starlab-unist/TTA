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
        
        if (tempA instanceof String) tempA = tempA.replace(',', '.');
        if (tempB instanceof String) tempB = tempB.replace(',', '.');
        
        double numA = Double.parseDouble(tempA);
        double numB = Double.parseDouble(tempB);
        
        if (numA == numB) return null;
        return numA > numB ? a : b;
    }

    // Transformed Code
    public static Object evaluate_and_compare(Object value1, Object value2) {
        String modified_val1 = value1.toString();
        String modified_val2 = value2.toString();

        if (modified_val1.contains(",")) {
            modified_val1 = modified_val1.replace(',', '.');
        }
        if (modified_val2.contains(",")) {
            modified_val2 = modified_val2.replace(',', '.');
        }

        double numeric_val1 = Double.parseDouble(modified_val1);
        double numeric_val2 = Double.parseDouble(modified_val2);

        if (numeric_val1 == numeric_val2) {
            return null;
        } else if (numeric_val1 > numeric_val2) {
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
        assertEquals(compareOne(testCases[0][0], testCases[0][1]), evaluate_and_compare(testCases[0][0], testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(compareOne(testCases[1][0], testCases[1][1]), evaluate_and_compare(testCases[1][0], testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(compareOne(testCases[2][0], testCases[2][1]), evaluate_and_compare(testCases[2][0], testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(compareOne(testCases[3][0], testCases[3][1]), evaluate_and_compare(testCases[3][0], testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(compareOne(testCases[4][0], testCases[4][1]), evaluate_and_compare(testCases[4][0], testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(compareOne(testCases[5][0], testCases[5][1]), evaluate_and_compare(testCases[5][0], testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(compareOne(testCases[6][0], testCases[6][1]), evaluate_and_compare(testCases[6][0], testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(compareOne(testCases[7][0], testCases[7][1]), evaluate_and_compare(testCases[7][0], testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(compareOne(testCases[8][0], testCases[8][1]), evaluate_and_compare(testCases[8][0], testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(compareOne(testCases[9][0], testCases[9][1]), evaluate_and_compare(testCases[9][0], testCases[9][1]));
    }
}