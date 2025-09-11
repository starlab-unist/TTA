import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
// Source Code
public static boolean simplify(String x, String n) {
    String[] partsX = x.split("/");
    String[] partsN = n.split("/");
    int numerator = Integer.parseInt(partsX[0]) * Integer.parseInt(partsN[0]);
    int denom = Integer.parseInt(partsX[1]) * Integer.parseInt(partsN[1]);
    if ((double) numerator / denom == Math.floor((double) numerator / denom)) {
        return true;
    }
    return false;
}

// Transformed Code
public static boolean checkFractionSimplification(String fraction1, String fraction2) {
    String[] parts1 = fraction1.split("/");
    String[] parts2 = fraction2.split("/");

    int a = Integer.parseInt(parts1[0]);
    int b = Integer.parseInt(parts1[1]);
    int c = Integer.parseInt(parts2[0]);
    int d = Integer.parseInt(parts2[1]);

    int resultNumerator = a * c;
    int resultDenominator = b * d;

    return resultNumerator % resultDenominator == 0;
}

// Test Cases
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_144 {

    // Original Implementation Wrapper
    public static class OriginalImpl {
        public static boolean simplify(String x, String n) {
            String[] partsX = x.split("/");
            String[] partsN = n.split("/");
            int numerator = Integer.parseInt(partsX[0]) * Integer.parseInt(partsN[0]);
            int denom = Integer.parseInt(partsX[1]) * Integer.parseInt(partsN[1]);
            if ((double) numerator / denom == Math.floor((double) numerator / denom)) {
                return true;
            }
            return false;
        }
    }

    // Transformed Implementation Wrapper
    public static class TransformedImpl {
        public static boolean checkFractionSimplification(String fraction1, String fraction2) {
            String[] parts1 = fraction1.split("/");
            String[] parts2 = fraction2.split("/");

            int a = Integer.parseInt(parts1[0]);
            int b = Integer.parseInt(parts1[1]);
            int c = Integer.parseInt(parts2[0]);
            int d = Integer.parseInt(parts2[1]);

            int resultNumerator = a * c;
            int resultDenominator = b * d;

            return resultNumerator % resultDenominator == 0;
        }
    }

    // Method to provide test cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of("1/2", "2/4"),   // True: (1*2) / (2*4) = 1/4
            Arguments.of("3/4", "4/8"),   // True: (3*4) / (4*8) = 12/32 = 3/8
            Arguments.of("5/6", "2/3"),   // False: (5*2) / (6*3) = 10/18 != int(10/18)
            Arguments.of("7/9", "9/18"),  // True: (7*9) / (9*18) = 63/162 = 7/18
            Arguments.of("1/1", "1/1"),   // True: (1*1) / (1*1) = 1
            Arguments.of("0/1", "5/10"),  // True: (0*5) / (1*10) = 0
            Arguments.of("2/3", "3/6"),   // False: (2*3) / (3*6) = 6/18 != int(6/18)
            Arguments.of("10/20", "20/40"), // True: (10*20) / (20*40) = 200/800 = 1/4
            Arguments.of("1/3", "3/9"),   // True: (1*3) / (3*9) = 3/27 = 1/9
            Arguments.of("5/7", "7/14")   // False: (5*7) / (7*14) = 35/98 != int(35/98)
        );
    }

    // Parameterized Test Method
    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testSimplify(String x, String n) {
        assertEquals(OriginalImpl.simplify(x, n), TransformedImpl.checkFractionSimplification(x, n));
    }
}