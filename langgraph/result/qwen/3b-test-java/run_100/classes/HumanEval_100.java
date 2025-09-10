public class HumanEval_100 {
    public static int[] constructStack(int size) {
        int[] pile = new int[size];
        int index = 0;
        while (index < size) {
            pile[index] = size + 2 * index;
            index++;
        }
        return pile;
    }
}