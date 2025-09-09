public class HumanEval_32 {

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