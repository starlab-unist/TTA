public class HumanEval_161 {
    public String solve(String s) {
        int flg = 0;
        int idx = 0;
        char[] newStr = s.toCharArray();
        for (char i : s.toCharArray()) {
            if (Character.isLetter(i)) {
                newStr[idx] = Character.isUpperCase(i) ? Character.toLowerCase(i) : Character.toUpperCase(i);
                flg = 1;
            }
            idx++;
        }
        StringBuilder result = new StringBuilder(new String(newStr));
        if (flg == 0) {
            return result.reverse().toString();
        }
        return result.toString();
    }
}