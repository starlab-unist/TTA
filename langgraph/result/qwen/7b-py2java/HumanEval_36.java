import java.util.ArrayList;
import java.util.List;

public class HumanEval_36 {
    public static int fizzBuzz(int n) {
        List<Integer> ns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i % 11 == 0 || i % 13 == 0) {
                ns.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer num : ns) {
            sb.append(num.toString());
        }
        String s = sb.toString();
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (c == '7') {
                ans++;
            }
        }
        return ans;
    }
}