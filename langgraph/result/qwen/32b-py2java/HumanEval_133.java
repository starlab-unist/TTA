class HumanEval_133 {
    public static int sumSquares(double[] lst) {
        int squared = 0;
        for (double i : lst) {
            squared += Math.pow(Math.ceil(i), 2);
        }
        return squared;
    }
}