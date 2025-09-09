import java.util.Arrays;

public class HumanEval_88 {
    public static int[] arrangeSequence(int[] sequence) {
        if (sequence.length == 0) {
            return new int[0];
        }
        
        boolean reverseOrder = (sequence[0] + sequence[sequence.length - 1]) % 2 == 0;
        Arrays.sort(sequence);
        
        if (reverseOrder) {
            for (int i = 0; i < sequence.length / 2; i++) {
                int temp = sequence[i];
                sequence[i] = sequence[sequence.length - 1 - i];
                sequence[sequence.length - 1 - i] = temp;
            }
        }
        
        return sequence;
    }
}