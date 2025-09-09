public class HumanEval_72 {

    public static boolean willItFly(int[] q, int w) {
        if (Arrays.stream(q).sum() > w) {
            return false;
        }

        int i = 0;
        int j = q.length - 1;
        while (i < j) {
            if (q[i] != q[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}