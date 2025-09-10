public class HumanEval_63 {
    public static int calculate_modified_fibonacci(int index) {
        if (index == 0) {
            return 0;
        } else if (index == 1) {
            return 0;
        } else if (index == 2) {
            return 1;
        } else {
            return (calculate_modified_fibonacci(index - 1) +
                    calculate_modified_fibonacci(index - 2) +
                    calculate_modified_fibonacci(index - 3));
        }
    }
}