public class HumanEval_52 {

    public static boolean belowThreshold(List<Integer> l, int t) {
        int index = 0;
        while (index < l.size()) {
            if (l.get(index) >= t) {
                return false;
            }
            index++;
        }
        return true;
    }
}