import java.util.ArrayList;
import java.util.Collections;

public class HumanEval_116 {

    public static ArrayList<Integer> arrangeByBinaryOnes(ArrayList<Integer> sequence) {
        return new ArrayList<>(Collections.sort(new ArrayList<>(sequence), (a, b) -> Integer.compare(countOnesInBinary(a), countOnesInBinary(b))));
    }

    private static int countOnesInBinary(int number) {
        return Integer.bitCount(number);
    }
}