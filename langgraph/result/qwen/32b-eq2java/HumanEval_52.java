public class HumanEval_52 {
    public boolean allElementsUnderLimit(int[] elements, int threshold) {
        int index = 0;
        while (index < elements.length) {
            if (elements[index] >= threshold) {
                return false;
            }
            index++;
        }
        return true;
    }
}