public class HumanEval_154 {
    public static boolean cycpattern_check(String a, String b) {
        int l = b.length();
        String pat = b + b;
        int index = 0;
        
        while (index <= a.length() - l) {
            int subIndex = 0;
            while (subIndex <= l) {
                if (a.substring(index, index + l).equals(pat.substring(subIndex, subIndex + l))) {
                    return true;
                }
                subIndex++;
            }
            index++;
        }
        
        return false;
    }
}