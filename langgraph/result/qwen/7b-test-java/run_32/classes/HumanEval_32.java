import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_32 {

    // Source Code
    static class HumanEval_32_Source {
        public static double poly(double[] xs, double x) {
            double result = 0.0;
            for (int i = 0; i < xs.length; i++) {
                result += xs[i] * Math.pow(x, i);
            }
            return result;
        }

        public static double findZero(double[] xs) {
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
    private static final double[][] testCasesPoly = {
        {1}, {1, -3, 2}, {1, 0, -4}, {2, -4, 2},
        {1, -6, 11, -6}, {1, -3, 3, -1}, {1, 0, 0, 0, -1},
        {1, -5, 10, -10, 5, -1}, {0, 1}, {0, 0, 1}
    };

    private static final double[] testPoints = {
        2.0, 2.0, 2.0, 1.0,
        3.0, 1.0, 1.0, 1.0, 0.0, 0.0
    };

    @Test
    public void test_poly_and_evaluate_polynomial() {
        for (int i = 0; i < testCasesPoly.length; i++) {
            double[] coefficients = testCasesPoly[i];
            double point = testPoints[i];
            assertEquals(HumanEval_32_Source.poly(coefficients, point), 
                         HumanEval_32_Transformed.evaluatePolynomial(coefficients, point), 1e-9);
        }
    }

    @Test
    public void test_find_zero_and_locate_root() {
        for (double[] coefficients : testCasesPoly) {
            double root1 = HumanEval_32_Source.findZero(coefficients);
            double root2 = HumanEval_32_Transformed.locateRoot(coefficients);
            assertEquals(root1, root2, 1e-5);
        }
    }
}