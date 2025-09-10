public class HumanEval_36 {
    public static int fizzBuzz(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 11 == 0 || i % 13 == 0) {
                sb.append(i);
            }
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