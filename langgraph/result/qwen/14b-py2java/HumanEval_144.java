public class HumanEval_144 {
    public static boolean simplify(String x, String n) {
        String[] partsX = x.split("/");
        String[] partsN = n.split("/");
        int a = Integer.parseInt(partsX[0]);
        int b = Integer.parseInt(partsX[1]);
        int c = Integer.parseInt(partsN[0]);
        int d = Integer.parseInt(partsN[1]);
        int numerator = a * c;
        int denom = b * d;
        return (numerator / denom == (double) numerator / denom);
    }
}