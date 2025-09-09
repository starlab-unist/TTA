public class HumanEval_66 {

    public static int digitSum(String s) {
        if (s.isEmpty()) return 0;
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sum += (int) c;
            }
        }
        return sum;
    }

}