public class HumanEval_35 {
    public static int find_maximum_value(int[] elements) {
        int current_max = elements[0];
        int index = 1;
        while (index < elements.length) {
            if (elements[index] > current_max) {
                current_max = elements[index];
            }
            index += 1;
        }
        return current_max;
    }
}