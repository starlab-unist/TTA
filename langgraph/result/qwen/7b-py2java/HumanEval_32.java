public class HumanEval_32 {

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