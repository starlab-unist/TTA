import java.util.List;

public class HumanEval_8 {

    public static int[] sumProduct(List<Integer> numbers) {
        int sumValue = 0;
        int prodValue = 1;

        for (int n : numbers) {
            sumValue += n;
            prodValue *= n;
        }
        return new int[]{sumValue, prodValue};
    }
}