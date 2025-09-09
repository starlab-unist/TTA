public class HumanEval_85 {
    public static int add(int[] lst) {
        return java.util.Arrays.stream(lst).skip(1).filter(i -> i % 2 == 0).sum();
    }
}