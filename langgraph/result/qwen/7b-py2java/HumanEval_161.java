public class HumanEval_161 {
    public static String solve(String s) {
        boolean flag = false;
        int index = 0;
        char[] newStr = s.toCharArray();
        
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                newStr[index] = Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
                flag = true;
            }
            index++;
        }
        
        if (!flag) {
            return new StringBuilder(s).reverse().toString();
        }
        
        return new String(newStr);
    }
}