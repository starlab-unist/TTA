class HumanEval_72 {
    public static boolean willItFly(int[] q, int w) {
        if (sumArray(q) > w) {
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

    private static int sumArray(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }
}