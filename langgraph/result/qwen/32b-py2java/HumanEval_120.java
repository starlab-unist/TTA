import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class HumanEval_120 {
    public List<Integer> maximum(int[] arr, int k) {
        if (k == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(arr);
        List<Integer> ans = new ArrayList<>();
        for (int i = arr.length - k; i < arr.length; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}