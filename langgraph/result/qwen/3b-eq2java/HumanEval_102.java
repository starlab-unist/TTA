public class HumanEval_102 {

    public static int selectNumber(int a, int b) {
        if (a > b) {
            return -1;
        } else if (b % 2 == 0) {
            return b;
        } else if (a == b) {
            return -1;
        } else {
            return b - 1;
        }
    }
}