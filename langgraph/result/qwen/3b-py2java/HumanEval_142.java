public class HumanEval_142 {

    public static int sumSquares(int[] lst) {
        int result = 0;
        for (int i = 0; i < lst.length; i++) {
            if (i % 3 == 0) {
                result += lst[i] * lst[i];
            } else if (i % 4 == 0 && i % 3 != 0) {
                result += lst[i] * lst[i] * lst[i];
            } else {
                result += lst[i];
            }
        }
        return result;
    }
}