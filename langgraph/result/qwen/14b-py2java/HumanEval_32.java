import java.util.List;

public class HumanEval_32 {

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