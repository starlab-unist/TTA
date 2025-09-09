import java.util.ArrayList;
import java.util.List;

class HumanEval_147 {
    public int getMaxTriples(int n) {
        List<Integer> A = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            A.add(i * i - i + 1);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((A.get(i) + A.get(j) + A.get(k)) % 3 == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}