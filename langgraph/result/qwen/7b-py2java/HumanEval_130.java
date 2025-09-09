public class HumanEval_130 {
    public static double[] tri(int n) {
        if (n == 0) {
            return new double[]{1};
        }
        double[] myTri = {1, 3};
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                myTri[i] = i / 2.0 + 1;
            } else {
                myTri[i] = myTri[i - 1] + myTri[i - 2] + (i + 3) / 2.0;
            }
        }
        return myTri;
    }
}