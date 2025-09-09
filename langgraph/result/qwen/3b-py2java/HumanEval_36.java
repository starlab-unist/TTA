public class HumanEval_36 {
    public static int fizzBuzz(int n) {
        StringBuilder ns = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 11 == 0 || i % 13 == 0) {
                ns.append(i);
            }
        }
        String s = ns.toString();
        int ans = 0;
        for (char c : s.toCharArray()) {
            ans += (c == '7') ? 1 : 0;
        }
        return ans;
    }
}