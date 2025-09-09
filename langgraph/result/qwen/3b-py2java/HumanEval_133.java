public class HumanEval_133 {

    public static int sumSquares(double[] lst) {
        int squared = 0;
        for (double i : lst) {
            squared += Math.ceil(i) * Math.ceil(i);
        }
        return squared;
    }
}