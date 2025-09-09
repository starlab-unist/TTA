public class HumanEval_35 {
    public static int maxElement(int[] l) {
        int m = l[0];
        for (int e : l) {
            if (e > m) {
                m = e;
            }
        }
        return m;
    }
}