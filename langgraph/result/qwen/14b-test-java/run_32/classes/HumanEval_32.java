import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_32 {

    // Source Code
    static class SourceCode {
        public static double poly(List<Double> xs, double x) {
            double result = 0.0;
            for (int i = 0; i < xs.size(); i++) {
                result += xs.get(i) * Math.pow(x, i);
            }
            return result;
        }

        public static double find_zero(List<Double> xs) {
            double begin = -1.0, end = 1.0;
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
    static class TransformedCode {
        public static double evaluatePolynomial(List<Double> coefficients, double value) {
            double result = 0.0;
            for (int index = 0; index < coefficients.size(); index++) {
                result += coefficients.get(index) * Math.pow(value, index);
            }
            return result;
        }

        public static double locateRoot(List<Double> polynomialCoeffs) {
            double lowerBound = -1.0, upperBound = 1.0;
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

    // Test Cases
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
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest(name = "Test case {index}: coefficients={0}, point={1}")
    @MethodSource("provideTestCases")
    void test_poly_and_evaluatePolynomial(List<Double> coefficients, double point) {
        assertEquals(
            SourceCode.poly(coefficients, point),
            TransformedCode.evaluatePolynomial(coefficients, point),
            1e-9
        );
    }

    private static final Object[][] rootTestCases = {
        {Arrays.asList(1.0)},
        {Arrays.asList(1.0, -3.0, 2.0)},  
        {Arrays.asList(1.0, 0.0, -4.0)},  
        {Arrays.asList(2.0, -4.0, 2.0)},  
        {Arrays.asList(1.0, -6.0, 11.0, -6.0)},
        {Arrays.asList(1.0, -3.0, 3.0, -1.0)},
        {Arrays.asList(1.0, 0.0, 0.0, 0.0, -1.0)},
        {Arrays.asList(1.0, -5.0, 10.0, -10.0, 5.0, -1.0)},  
        {Arrays.asList(0.0, 1.0)}, 
        {Arrays.asList(0.0, 0.0, 1.0)}  
    };

    private static Stream<Arguments> provideRootTestCases() {
        return Arrays.stream(rootTestCases).map(Arguments::of);
    }

    @ParameterizedTest(name = "Test case {index}: coefficients={0}")
    @MethodSource("provideRootTestCases")
    void test_find_zero_and_locateRoot(List<Double> coefficients) {
        assertEquals(
            SourceCode.find_zero(coefficients),
            TransformedCode.locateRoot(coefficients),
            1e-5
        );
    }
}