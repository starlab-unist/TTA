public class HumanEval_144 {
    public static boolean simplify(String x, String n) {
        String[] partsX = x.split("/");
        String[] partsN = n.split("/");
        int numerator = Integer.parseInt(partsX[0]) * Integer.parseInt(partsN[0]);
        int denom = Integer.parseInt(partsX[1]) * Integer.parseInt(partsN[1]);
        if ((double) numerator / denom == Math.floor((double) numerator / denom)) {
            return true;
        }
        return false;
    }
}