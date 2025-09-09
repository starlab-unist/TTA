import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;

public class HumanEval_32 {

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

    // Test Cases for poly vs evaluatePolynomial
    private static final List<Arguments> polynomialTestCases = Arrays.asList(
        Arguments.of(Arrays.asList(1.0), 2.0),
        Arguments.of(Arrays.asList(1.0, -3.0, 2.0), 2.0),  // x^2 - 3x + 2 = (x-1)(x-2)
        Arguments.of(Arrays.asList(1.0, 0.0, -4.0), 2.0),  // x^2 - 4 = (x-2)(x+2)
        Arguments.of(Arrays.asList(2.0, -4.0, 2.0), 1.0),  // 2x^2 - 4x + 2 = 2(x-1)^2
        Arguments.of(Arrays.asList(1.0, -6.0, 11.0, -6.0), 3.0),  // x^3 - 6x^2 + 11x - 6 = (x-1)(x-2)(x-3)
        Arguments.of(Arrays.asList(1.0, -3.0, 3.0, -1.0), 1.0),  // x^3 - 3x^2 + 3x - 1 = (x-1)^3
        Arguments.of(Arrays.asList(1.0, 0.0, 0.0, 0.0, -1.0), 1.0),  // x^4 - 1 = (x-1)(x+1)(x^2+1)
        Arguments.of(Arrays.asList(1.0, -5.0, 10.0, -10.0, 5.0, -1.0), 1.0),  // x^5 - 5x^4 + 10x^3 - 10x^2 + 5x - 1 = (x-1)^5
        Arguments.of(Arrays.asList(0.0, 1.0), 0.0),  // x
        Arguments.of(Arrays.asList(0.0, 0.0, 1.0), 0.0)  // x^2
    );

    @ParameterizedTest(name = "Test case {index}: coefficients={0}, point={1}")
    @MethodSource("providePolynomialTestCases")
    void poly_vs_evaluatePolynomial(List<Double> coefficients, double point) {
        double sourceResult = HumanEval_32_Source.poly(coefficients, point);
        double transformedResult = HumanEval_32_Transformed.evaluatePolynomial(coefficients.stream().mapToDouble(Double::doubleValue).toArray(), point);
        assertEquals(sourceResult, transformedResult, 1e-9);
    }

    // Test Cases for findZero vs locateRoot
    private static final List<Arguments> rootTestCases = Arrays.asList(
        Arguments.of(Arrays.asList(1.0)),  // x - 1 = 0
        Arguments.of(Arrays.asList(1.0, -3.0, 2.0)),  // x^2 - 3x + 2 = (x-1)(x-2)
        Arguments.of(Arrays.asList(1.0, 0.0, -4.0)),  // x^2 - 4 = (x-2)(x+2)
        Arguments.of(Arrays.asList(2.0, -4.0, 2.0)),  // 2x^2 - 4x + 2 = 2(x-1)^2
        Arguments.of(Arrays.asList(1.0, -6.0, 11.0, -6.0)),  // x^3 - 6x^2 + 11x - 6 = (x-1)(x-2)(x-3)
        Arguments.of(Arrays.asList(1.0, -3.0, 3.0, -1.0)),  // x^3 - 3x^2 + 3x - 1 = (x-1)^3
        Arguments.of(Arrays.asList(1.0, 0.0, 0.0, 0.0, -1.0)),  // x^4 - 1 = (x-1)(x+1)(x^2+1)
        Arguments.of(Arrays.asList(1.0, -5.0, 10.0, -10.0, 5.0, -1.0)),  // x^5 - 5x^4 + 10x^3 - 10x^2 + 5x - 1 = (x-1)^5
        Arguments.of(Arrays.asList(0.0, 1.0)),  // x
        Arguments.of(Arrays.asList(0.0, 0.0, 1.0))  // x^2
    );

    @ParameterizedTest(name = "Root test case {index}: coefficients={0}")
    @MethodSource("provideRootTestCases")
    void findZero_vs_locateRoot(List<Double> coefficients) {
        double rootSource = HumanEval_32_Source.findZero(coefficients);
        double rootTransformed = HumanEval_32_Transformed.locateRoot(coefficients.stream().mapToDouble(Double::doubleValue).toArray());
        assertEquals(rootSource, rootTransformed, 1e-5);
    }

    private static Stream<Arguments> providePolynomialTestCases() {
        return polynomialTestCases.stream();
    }

    private static Stream<Arguments> provideRootTestCases() {
        return rootTestCases.stream();
    }
}