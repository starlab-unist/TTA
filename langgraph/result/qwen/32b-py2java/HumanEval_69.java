class HumanEval_69 {
    public static int search(int[] lst) {
        int maxVal = 0;
        for (int num : lst) {
            if (num > maxVal) {
                maxVal = num;
            }
        }

        int[] frq = new int[maxVal + 1];
        for (int i : lst) {
            frq[i]++;
        }

        int ans = -1;
        for (int i = 1; i < frq.length; i++) {
            if (frq[i] >= i) {
                ans = i;
            }
        }

        return ans;
    }
}