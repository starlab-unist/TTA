public class HumanEval_57 {

    public static boolean monotonic(List<Integer> l) {
        if (l.equals(new ArrayList<>(Collections.sort(l))) || l.equals(new ArrayList<>(Collections.sort(l).reverse()))) {
            return true;
        }
        return false;
    }
}