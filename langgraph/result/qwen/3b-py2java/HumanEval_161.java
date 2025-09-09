public class HumanEval_161 {

    public static String solve(String s) {
        int flg = 0;
        StringBuilder newStr = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                newStr.setCharAt(i, Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
                flg = 1;
            }
        }
        s = newStr.toString();
        if (flg == 0) {
            return s.substring(s.length() - 1, -1, -1);
        }
        return s;
    }

}