public class HumanEval_121 {
    public static int solution(int[] lst) {
        return java.util.Arrays.stream(lst)
                                .filter((idx, x) -> idx % 2 == 0 && x % 2 == 1)
                                .sum();
    }
}