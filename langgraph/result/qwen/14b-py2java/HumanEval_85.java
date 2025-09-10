public class HumanEval_85 {
    public static int add(int[] lst) {
        int sum = 0;
        for (int i = 1; i < lst.length; i += 2) {
            if (lst[i] % 2 == 0) {
                sum += lst[i];
            }
        }
        return sum;
    }
}