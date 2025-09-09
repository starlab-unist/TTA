public class HumanEval_35 {

    public static int findMaximumValue(List<Integer> elements) {
        int currentMax = elements.get(0);
        int index = 1;
        while (index < elements.size()) {
            if (elements.get(index) > currentMax) {
                currentMax = elements.get(index);
            }
            index++;
        }
        return currentMax;
    }
}