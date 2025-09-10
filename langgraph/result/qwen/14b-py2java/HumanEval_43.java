public class HumanEval_43 {
    public static boolean pairsSumToZero(int[] l) {
        for (int i = 0; i < l.length; i++) {
            int l1 = l[i];
            for (int j = i + 1; j < l.length; j++) {
                if (l1 + l[j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}