public class HumanEval_55 {
    public static int calculate_fibonacci(int sequence_index) {
        if (sequence_index == 0) {
            return 0;
        } else if (sequence_index == 1) {
            return 1;
        }

        int previous = 0, current = 1;
        int index = 2;
        while (index <= sequence_index) {
            int next = current + previous;
            previous = current;
            current = next;
            index++;
        }

        return current;
    }
}