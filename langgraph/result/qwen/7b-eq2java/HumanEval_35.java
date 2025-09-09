public class HumanEval_35 {
    public static int maxElement(int[] l) {
        int m = l[0];
        int index = 1;
        while (index < l.length) {
            if (l[index] > m) {
                m = l[index];
            }
            index += 1;
        }
        return m;
    }
}