public class HumanEval_35 {
    public int find_maximum_value(int[] elements) {
        int currentMax = elements[0];
        int index = 1;
        while (index < elements.length) {
            if (elements[index] > currentMax) {
                currentMax = elements[index];
            }
            index++;
        }
        return currentMax;
    }
}