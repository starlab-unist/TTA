public class HumanEval_119 {
    public static String matchParens(String[] lst) {
        return check(lst[0] + lst[1]) || check(lst[1] + lst[0]) ? "Yes" : "No";
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