import java.util.Arrays;

public class HumanEval_120 {
    public static int[] findTopKElements(int[] sequence, int count) {
        if (count == 0) {
            return new int[0];
        }

        int[] sortedSequence = Arrays.copyOf(sequence, sequence.length);
        Arrays.sort(sortedSequence);
        int[] topElements = new int[count];
        System.arraycopy(sortedSequence, sortedSequence.length - count, topElements, 0, count);

        return topElements;
    }
}