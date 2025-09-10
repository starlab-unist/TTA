{source_code}
// Source Code
static class HumanEval_32_Source {
    public static double poly(List<Double> xs, double x) {
        double result = 0.0;
        for (int i = 0; i < xs.size(); i++) {
            result += xs.get(i) * Math.pow(x, i);
        }
        return result;
    }

    public static double findZero(List<Double> xs) {
        double begin = -1.0;
        double end = 1.0;
        while (poly(xs, begin) * poly(xs, end) > 0) {
            begin *= 2.0;
            end *= 2.0;
        }
        while (end - begin > 1e-10) {
            double center = (begin + end) / 2.0;
            if (poly(xs, center) * poly(xs, begin) > 0) {
                begin = center;
            } else {
                end = center;
            }
        }
        return begin;
    }
}

// Transformed Code
static class HumanEval_32_Transformed {
    public static double evaluatePolynomial(double[] coefficients, double value) {
        double result = 0.0;
        for (int index = 0; index < coefficients.length; index++) {
            result += coefficients[index] * Math.pow(value, index);
        }
        return result;
    }

    public static double locateRoot(double[] polynomialCoeffs) {
        double lowerBound = -1.0;
        double upperBound = 1.0;
        while (evaluatePolynomial(polynomialCoeffs, lowerBound) * evaluatePolynomial(polynomialCoeffs, upperBound) > 0) {
            lowerBound *= 2.0;
            upperBound *= 2.0;
        }
        
        while (upperBound - lowerBound > 1e-10) {
            double midpoint = (lowerBound + upperBound) / 2.0;
            if (evaluatePolynomial(polynomialCoeffs, midpoint) * evaluatePolynomial(polynomialCoeffs, lowerBound) > 0) {
                lowerBound = midpoint;
            } else {
                upperBound = midpoint;
            }
        }
        
        return lowerBound;
    }
}

{test_cases}
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;  // Added missing import statement

public class HumanEval_32 {

    private static final Object[][] testCases = {
        {Arrays.asList(1.0), 2.0},
        {Arrays.asList(1.0, -3.0, 2.0), 2.0},  // x^2 - 3x + 2 = (x-1)(x-2)
        {Arrays.asList(1.0, 0.0, -4.0), 2.0},  // x^2 - 4 = (x-2)(x+2)
        {Arrays.asList(2.0, -4.0, 2.0), 1.0},  // 2x^2 - 4x + 2 = 2(x-1)^2
        {Arrays.asList(1.0, -6.0, 11.0, -6.0), 3.0},  // x^3 - 6x^2 + 11x - 6 = (x-1)(x-2)(x-3)
        {Arrays.asList(1.0, -3.0, 3.0, -1.0), 1.0},  // x^3 - 3x^2 + 3x - 1 = (x-1)^3
        {Arrays.asList(1.0, 0.0, 0.0, 0.0, -1.0), 1.0},  // x^4 - 1 = (x-1)(x+1)(x^2+1)
        {Arrays.asList(1.0, -5.0, 10.0, -10.0, 5.0, -1.0), 1.0},  // x^5 - 5x^4 + 10x^3 - 10x^2 + 5x - 1 = (x-1)^5
        {Arrays.asList(0.0, 1.0), 0.0},  // x
        {Arrays.asList(0.0, 0.0, 1.0), 0.0}  // x^2
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(args -> Arguments.of((List<Double>) args[0], (double) args[1]));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void test_poly_and_evaluate_polynomial(List<Double> coefficients, double point) {
        double[] coeffsArray = coefficients.stream().mapToDouble(Double::doubleValue).toArray();
        assertEquals(
            HumanEval_32_Source.poly(coefficients, point),
            HumanEval_32_Transformed.evaluatePolynomial(coeffsArray, point),
            1e-9
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void test_find_zero_and_locate_root(List<Double> coefficients, double ignoredPoint) {
        double[] coeffsArray = coefficients.stream().mapToDouble(Double::doubleValue).toArray();
        assertEquals(
            HumanEval_32_Source.findZero(coefficients),
            HumanEval_32_Transformed.locateRoot(coeffsArray),
            1e-5
        );
    }
}