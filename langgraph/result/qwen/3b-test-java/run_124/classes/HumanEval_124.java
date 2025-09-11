import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class HumanEval_124 {

    // Source Code (with corrected syntax error)
    static class OriginalImpl {
        public static boolean validDate(String date) {
            try {
                date = date.strip();
                String[] parts = date.split("-");
                if (parts.length != 3) {
                    return false;
                }

                int month = Integer.parseInt(parts[0]);
                int day = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);

                if (month < 1 || month > 12) {
                    return false;
                }
                if (month == 2 && (day < 1 || day > 29)) {
                    return false;
                }
                if ((month == 4 || month == 6 || month == 9 || month == 11) && (day < 1 || day > 30)) {
                    return false;
                }
                if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day < 1 || day > 31)) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }

            return true;
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public static boolean checkValidDate(String d) {
            try {
                d = d.trim();
                String[] parts = d.split("-");
                
                int m = Integer.parseInt(parts[0]);
                int d = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                
                if (!isValidMonth(m)) {
                    return false;
                }
                
                if (m == 2 && !isLeapYear(y)) {
                    return false;
                }
                
                if (!isValidDay(m, d)) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
            
            return true;
        }

        private static boolean isValidMonth(int m) {
            return m >= 1 && m <= 12;
        }

        private static boolean isLeapYear(int y) {
            return y % 4 == 0 && (y % 100 != 0 || y % 400 == 0);
        }

        private static boolean isValidDay(int m, int d) {
            switch (m) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    return d >= 1 && d <= 31;
                case 4: case 6: case 9: case 11:
                    return d >= 1 && d <= 30;
                case 2:
                    return d >= 1 && d <= 29;
                default:
                    return false;
            }
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of("01-15-2023"),   // valid date
            Arguments.of("02-29-2024"),   // valid leap year date
            Arguments.of("04-31-2023"),   // invalid date, April has 30 days
            Arguments.of("13-01-2023"),   // invalid month
            Arguments.of("00-10-2023"),   // invalid month
            Arguments.of("06-00-2023"),   // invalid day
            Arguments.of("06-32-2023"),   // invalid day
            Arguments.of("02-30-2023"),   // invalid date, February has 29 days in a leap year
            Arguments.of("-1-15-2023"),   // invalid format
            Arguments.of("01--15-2023")   // invalid format
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testDateValidation(String date) {
        assertEquals(OriginalImpl.validDate(date), TransformedImpl.checkValidDate(date));
    }
}