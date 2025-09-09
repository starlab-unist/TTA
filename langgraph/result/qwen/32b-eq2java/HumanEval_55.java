public class HumanEval_55 {
    public static int calculateFibonacci(int sequenceIndex) {
        if (sequenceIndex == 0) {
            return 0;
        } else if (sequenceIndex == 1) {
            return 1;
        }

        int previous = 0, current = 1;
        int index = 2;
        while (index <= sequenceIndex) {
            int next = previous + current;
            previous = current;
            current = next;
            index++;
        }

        return current;
    }
}