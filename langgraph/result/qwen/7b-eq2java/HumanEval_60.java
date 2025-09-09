public class HumanEval_60 {
    public static int calculateTotalUpTo(int number) {
        int totalSum = 0;
        int current = 0;
        
        while (current <= number) {
            totalSum += current;
            current += 1;
        }
        
        return totalSum;
    }
}