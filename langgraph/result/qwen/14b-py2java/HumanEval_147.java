import java.util.ArrayList;
import java.util.List;

public class HumanEval_147 {
    public static int getMaxTriples(int n) {
        List<Integer> A = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            A.add(i * i - i + 1);
        }

        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((A.get(i) + A.get(j) + A.get(k)) % 3 == 0) {
                        ans.add(new int[]{A.get(i), A.get(j), A.get(k)});
                    }
                }
            }
        }
        return ans.size();
    }
}