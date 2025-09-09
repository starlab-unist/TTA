public class HumanEval_155 {
    public static Pair<Integer, Integer> evenOddCount(int num) {
        int evenCount = 0;
        int oddCount = 0;
        for (char c : String.valueOf(Math.abs(num)).toCharArray()) {
            if ((c - '0') % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        return new Pair<>(evenCount, oddCount);
    }
}