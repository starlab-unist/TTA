public class HumanEval_144 {

    public static boolean simplify(String x, String n) {
        String[] a = x.split("/");
        String[] b = n.split("/");
        int numerator = Integer.parseInt(a[0]) * Integer.parseInt(b[0]);
        int denominator = Integer.parseInt(a[1]) * Integer.parseInt(b[1]);
        return numerator / denominator == (numerator / denominator);
    }
}