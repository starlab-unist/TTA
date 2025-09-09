public class HumanEval_137 {

    public static Double compareOne(Double a, Double b) {
        if (a != null && b != null) {
            if (a.equals(b)) {
                return null;
            }
            return a.compareTo(b) > 0 ? a : b;
        }
        return null;
    }

}