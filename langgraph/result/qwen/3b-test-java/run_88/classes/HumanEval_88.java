public class HumanEval_88 {

    public static int[] arrangeSequence(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return new int[0];
        }

        boolean reverseOrder = (sequence[0] + sequence[sequence.length - 1]) % 2 == 0;
        return java.util.Arrays.stream(sequence).boxed().sorted(reverseOrder ? java.util.Collections.reverseOrder() : java.util.Collections.naturalOrder()).mapToInt(Integer::intValue).toArray();
    }
}