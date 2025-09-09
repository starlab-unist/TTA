import java.util.Arrays;
import java.util.Comparator;

public class HumanEval_116 {
    public static int[] arrangeByBinaryOnes(int[] sequence) {
        return Arrays.stream(sequence)
                     .boxed()
                     .sorted(Comparator.comparingInt(HumanEval_116::countOnesInBinary))
                     .mapToInt(Integer::intValue)
                     .toArray();
    }

    private static int countOnesInBinary(int number) {
        return Integer.bitCount(number);
    }
}