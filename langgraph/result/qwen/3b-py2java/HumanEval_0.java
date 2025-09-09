import java.util.List;

public class HumanEval_0 {

    public static boolean hasCloseElements(List<Float> numbers, float threshold) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                if (i != j) {
                    float distance = Math.abs(numbers.get(i) - numbers.get(j));
                    if (distance < threshold) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}