public class HumanEval_110 {
    public static String exchange(int[] lst1, int[] lst2) {
        int odd = 0;
        int even = 0;
        for (int i : lst1) {
            if (i % 2 == 1) {
                odd += 1;
            }
        }
        for (int i : lst2) {
            if (i % 2 == 0) {
                even += 1;
            }
        }
        if (even >= odd) {
            return "YES";
        }
        return "NO";
    }
}