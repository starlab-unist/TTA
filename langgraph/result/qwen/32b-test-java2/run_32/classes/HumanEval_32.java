import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_32 {

    // Source Code
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

    // Transformed Code
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

    // Test Cases
    private static final Object[][] testCases = {
        {List.of(1.0), 2.0},
        {List.of(1.0, -3.0, 2.0), 2.0},  // x^2 - 3x + 2 = (x-1)(x-2)
        {List.of(1.0, 0.0, -4.0), 2.0},  // x^2 - 4 = (x-2)(x+2)
        {List.of(2.0, -4.0, 2.0), 1.0},  // 2x^2 - 4x + 2 = 2(x-1)^2
        {List.of(1.0, -6.0, 11.0, -6.0), 3.0},  // x^3 - 6x^2 + 11x - 6 = (x-1)(x-2)(x-3)
        {List.of(1.0, -3.0, 3.0, -1.0), 1.0},  // x^3 - 3x^2 + 3x - 1 = (x-1)^3
        {List.of(1.0, 0.0, 0.0, 0.0, -1.0), 1.0},  // x^4 - 1 = (x-1)(x+1)(x^2+1)
        {List.of(1.0, -5.0, 10.0, -10.0, 5.0, -1.0), 1.0},  // x^5 - 5x^4 + 10x^3 - 10x^2 + 5x - 1 = (x-1)^5
        {List.of(0.0, 1.0), 0.0},  // x
        {List.of(0.0, 0.0, 1.0), 0.0}  // x^2
    };

    @Test
    public void test_poly_and_evaluate_polynomial() {
        for (Object[] testCase : testCases) {
            List<Double> coefficients = (List<Double>) testCase[0];
            double point = (double) testCase[1];

            double polyResult = poly(coefficients, point);
            double evaluatePolynomialResult = evaluatePolynomial(toArray(coefficients), point);

            assertEquals(polyResult, evaluatePolynomialResult, 1e-9);
        }
    }

    @Test
    public void test_find_zero_and_locate_root() {
        for (Object[] testCase : testCases) {
            List<Double> coefficients = (List<Double>) testCase[0];

            double findZeroResult = findZero(coefficients);
            double locateRootResult = locateRoot(toArray(coefficients));

            assertEquals(findZeroResult, locateRootResult, 1e-5);
        }
    }

    private static double[] toArray(List<Double> list) {
        double[] array = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}