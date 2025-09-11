import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_124 {

    // Source Code
    public static boolean validDate(String date) {
        try {
            date = date.strip();
            String[] parts = date.split("-");
            int month = Integer.parseInt(parts[0]);
            int day = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            if (month < 1 || month > 12) {
                return false;
            }
            if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day < 1 || day > 31)) {
                return false;
            }
            if ((month == 4 || month == 6 || month == 9 || month == 11) && (day < 1 || day > 30)) {
                return false;
            }
            if (month == 2 && (day < 1 || day > 29)) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    // Transformed Code
    public static boolean check_valid_date(String d) {
        try {
            d = d.strip();
            String[] parts = d.split("-");
            int m = Integer.parseInt(parts[0]);
            int d2 = Integer.parseInt(parts[1]);
            int y = Integer.parseInt(parts[2]);

            if (!(1 <= m && m <= 12)) {
                return false;
            }

            if ((m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) && !(1 <= d2 && d2 <= 31)) {
                return false;
            }

            if ((m == 4 || m == 6 || m == 9 || m == 11) && !(1 <= d2 && d2 <= 30)) {
                return false;
            }

            if (m == 2 && !(1 <= d2 && d2 <= 29)) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    // Test Cases
    private static final String[] testCases = {
        "01-15-2023",   // valid date
        "02-29-2024",   // valid leap year date
        "04-31-2023",   // invalid date, April has 30 days
        "13-01-2023",   // invalid month
        "00-10-2023",   // invalid month
        "06-00-2023",   // invalid day
        "06-32-2023",   // invalid day
        "02-30-2023",   // invalid date, February has 29 days in a leap year
        "-1-15-2023",   // invalid format
        "01--15-2023",  // invalid format
    };

    @Test
    public void test_0() {
        assertEquals(validDate(testCases[0]), check_valid_date(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(validDate(testCases[1]), check_valid_date(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(validDate(testCases[2]), check_valid_date(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(validDate(testCases[3]), check_valid_date(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(validDate(testCases[4]), check_valid_date(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(validDate(testCases[5]), check_valid_date(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(validDate(testCases[6]), check_valid_date(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(validDate(testCases[7]), check_valid_date(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(validDate(testCases[8]), check_valid_date(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(validDate(testCases[9]), check_valid_date(testCases[9]));
    }
}