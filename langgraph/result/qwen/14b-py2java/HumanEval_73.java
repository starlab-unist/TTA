public class HumanEval_73 {
    public static int smallestChange(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - i - 1]) {
                ans += 1;
            }
        }
        return ans;
    }
}