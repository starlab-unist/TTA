public class HumanEval_72 {
    public static boolean willItFly(int[] q, int w) {
        int sum = 0;
        for (int num : q) {
            sum += num;
        }
        if (sum > w) {
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
}