class HumanEval_121 {
    public int solution(int[] lst) {
        int sum = 0;
        for (int idx = 0; idx < lst.length; idx++) {
            if (idx % 2 == 0 && lst[idx] % 2 == 1) {
                sum += lst[idx];
            }
        }
        return sum;
    }
}