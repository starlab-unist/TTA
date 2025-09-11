import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_99 {

    // Source Code
    static class HumanEval_99_Source {
        public static int closestInteger(String value) {
            if (value.contains(".")) {
                // Remove trailing zeros
                while (value.endsWith("0")) {
                    value = value.substring(0, value.length() - 1);
                }
            }

            double num = Double.parseDouble(value);
            int res;
            if (value.endsWith(".5")) {
                if (num > 0) {
                    res = (int) Math.ceil(num);
                } else {
                    res = (int) Math.floor(num);
                }
            } else if (!value.isEmpty()) {
                res = (int) Math.round(num);
            } else {
                res = 0;
            }

            return res;
        }
    }

    // Transformed Code
    static class HumanEval_99_Transformed {
        public static int nearestWholeNumber(String inputValue) {
            if (inputValue.contains(".")) {
                // strip trailing zeros
                while (inputValue.endsWith("0")) {
                    inputValue = inputValue.substring(0, inputValue.length() - 1);
                }
            }

            double number = Double.parseDouble(inputValue);
            int result;
            if (inputValue.endsWith(".5")) {
                result = number > 0 ? (int) Math.ceil(number) : (int) Math.floor(number);
            } else if (!inputValue.isEmpty()) {
                result = (int) Math.round(number);
            } else {
                result = 0;
            }

            return result;
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "4.5",
        "-2.5",
        "3.7",
        "-1.2",
        "0.0",
        "5.000",
        "6.99",
        "-3.01",
        ".5",
        "-.5"
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_99_Source.closestInteger(testCases[0]), HumanEval_99_Transformed.nearestWholeNumber(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_99_Source.closestInteger(testCases[1]), HumanEval_99_Transformed.nearestWholeNumber(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_99_Source.closestInteger(testCases[2]), HumanEval_99_Transformed.nearestWholeNumber(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_99_Source.closestInteger(testCases[3]), HumanEval_99_Transformed.nearestWholeNumber(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_99_Source.closestInteger(testCases[4]), HumanEval_99_Transformed.nearestWholeNumber(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_99_Source.closestInteger(testCases[5]), HumanEval_99_Transformed.nearestWholeNumber(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_99_Source.closestInteger(testCases[6]), HumanEval_99_Transformed.nearestWholeNumber(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_99_Source.closestInteger(testCases[7]), HumanEval_99_Transformed.nearestWholeNumber(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_99_Source.closestInteger(testCases[8]), HumanEval_99_Transformed.nearestWholeNumber(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_99_Source.closestInteger(testCases[9]), HumanEval_99_Transformed.nearestWholeNumber(testCases[9]));
    }
}