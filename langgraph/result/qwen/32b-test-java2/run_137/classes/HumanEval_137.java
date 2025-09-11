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
    public static class HumanEval_137_Source {
        public static Object compareOne(Object a, Object b) {
            String tempA = a.toString();
            String tempB = b.toString();
            
            if (tempA.contains(",")) tempA = tempA.replace(',', '.');
            if (tempB.contains(",")) tempB = tempB.replace(',', '.');
            
            float numA = Float.parseFloat(tempA);
            float numB = Float.parseFloat(tempB);
            
            if (numA == numB) return null;
            return numA > numB ? a : b;
        }
    }

    // Transformed Code
    public static class HumanEval_137_Transformed {
        public Object evaluateAndCompare(Object value1, Object value2) {
            String modifiedVal1 = value1.toString();
            String modifiedVal2 = value2.toString();
            
            if (modifiedVal1.contains(",")) {
                modifiedVal1 = modifiedVal1.replace(',', '.');
            }
            if (modifiedVal2.contains(",")) {
                modifiedVal2 = modifiedVal2.replace(',', '.');
            }

            double numericVal1 = Double.parseDouble(modifiedVal1);
            double numericVal2 = Double.parseDouble(modifiedVal2);

            if (numericVal1 == numericVal2) {
                return null;
            } else if (numericVal1 > numericVal2) {
                return value1;
            } else {
                return value2;
            }
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
        assertEquals(HumanEval_137_Source.compareOne(testCases[0][0], testCases[0][1]), 
                     new HumanEval_137_Transformed().evaluateAndCompare(testCases[0][0], testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_137_Source.compareOne(testCases[1][0], testCases[1][1]), 
                     new HumanEval_137_Transformed().evaluateAndCompare(testCases[1][0], testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_137_Source.compareOne(testCases[2][0], testCases[2][1]), 
                     new HumanEval_137_Transformed().evaluateAndCompare(testCases[2][0], testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_137_Source.compareOne(testCases[3][0], testCases[3][1]), 
                     new HumanEval_137_Transformed().evaluateAndCompare(testCases[3][0], testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_137_Source.compareOne(testCases[4][0], testCases[4][1]), 
                     new HumanEval_137_Transformed().evaluateAndCompare(testCases[4][0], testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_137_Source.compareOne(testCases[5][0], testCases[5][1]), 
                     new HumanEval_137_Transformed().evaluateAndCompare(testCases[5][0], testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_137_Source.compareOne(testCases[6][0], testCases[6][1]), 
                     new HumanEval_137_Transformed().evaluateAndCompare(testCases[6][0], testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_137_Source.compareOne(testCases[7][0], testCases[7][1]), 
                     new HumanEval_137_Transformed().evaluateAndCompare(testCases[7][0], testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_137_Source.compareOne(testCases[8][0], testCases[8][1]), 
                     new HumanEval_137_Transformed().evaluateAndCompare(testCases[8][0], testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_137_Source.compareOne(testCases[9][0], testCases[9][1]), 
                     new HumanEval_137_Transformed().evaluateAndCompare(testCases[9][0], testCases[9][1]));
    }
}