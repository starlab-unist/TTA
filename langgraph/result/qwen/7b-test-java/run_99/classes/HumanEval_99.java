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
    public static int closestInteger(String value) {
        double num;
        try {
            num = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0;
        }

        if (value.contains(".")) {
            // remove trailing zeros
            while (value.endsWith("0")) {
                value = value.substring(0, value.length() - 1);
            }
        }

        if (value.endsWith(".5")) {
            if (num > 0) {
                return (int) Math.ceil(num);
            } else {
                return (int) Math.floor(num);
            }
        } else if (!value.isEmpty()) {
            return (int) Math.round(num);
        } else {
            return 0;
        }
    }

    // Transformed Code
    public static int nearestWholeNumber(String input_value) {
        if (input_value.contains(".")) {
            // strip trailing zeros
            while (input_value.endsWith("0")) {
                input_value = input_value.substring(0, input_value.length() - 1);
            }
        }

        double number;
        try {
            number = Double.parseDouble(input_value);
        } catch (NumberFormatException e) {
            return 0;
        }

        int result;
        if (input_value.endsWith(".5")) {
            result = number > 0 ? (int)Math.ceil(number) : (int)Math.floor(number);
        } else if (!input_value.isEmpty()) {
            result = (int)Math.round(number);
        } else {
            result = 0;
        }

        return result;
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
        assertEquals(closestInteger(testCases[0]), nearestWholeNumber(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(closestInteger(testCases[1]), nearestWholeNumber(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(closestInteger(testCases[2]), nearestWholeNumber(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(closestInteger(testCases[3]), nearestWholeNumber(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(closestInteger(testCases[4]), nearestWholeNumber(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(closestInteger(testCases[5]), nearestWholeNumber(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(closestInteger(testCases[6]), nearestWholeNumber(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(closestInteger(testCases[7]), nearestWholeNumber(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(closestInteger(testCases[8]), nearestWholeNumber(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(closestInteger(testCases[9]), nearestWholeNumber(testCases[9]));
    }
}