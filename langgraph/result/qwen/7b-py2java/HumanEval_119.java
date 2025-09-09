public class HumanEval_119 {
    public static String matchParens(String[] lst) {
        String S1 = lst[0] + lst[1];
        String S2 = lst[1] + lst[0];
        return check(S1) || check(S2) ? "Yes" : "No";
    }

    private static boolean check(String s) {
        int val = 0;
        for (char i : s.toCharArray()) {
            if (i == '(') {
                val++;
            } else {
                val--;
            }
            if (val < 0) {
                return false;
            }
        }
        return val == 0;
    }
}