public class HumanEval_72 {
    public static boolean willItFly(int[] q, int w) {
        if (sum(q) > w) {
            return false;
        }

        int i = 0, j = q.length - 1;
        while (i < j) {
            if (q[i] != q[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static int sum(int[] array) {
        int total = 0;
        for (int value : array) {
            total += value;
        }
        return total;
    }
}