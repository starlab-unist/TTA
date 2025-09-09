public class HumanEval_43 {
    public static boolean pairsSumToZero(int[] l) {
        for (int i = 0; i < l.length; i++) {
            for (int j = i + 1; j < l.length; j++) {
                if (l[i] + l[j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}