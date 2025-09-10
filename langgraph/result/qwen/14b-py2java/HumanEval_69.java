public class HumanEval_69 {
    public static int search(int[] lst) {
        int maxVal = Arrays.stream(lst).max().orElse(0);
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