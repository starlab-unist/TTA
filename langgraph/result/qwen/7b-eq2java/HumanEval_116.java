import java.util.Arrays;
import java.util.Comparator;

public class HumanEval_116 {

    public static int[] arrangeByBinaryOnes(int[] sequence) {
        Arrays.sort(sequence);
        Arrays.sort(sequence, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return countOnesInBinary(a) - countOnesInBinary(b);
            }
        });
        return sequence;
    }

    private static int countOnesInBinary(int number) {
        return Integer.bitCount(number);
    }
}