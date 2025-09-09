public class HumanEval_24 {
    public int findGreatestDivisor(int number) {
        int divisor = number - 1;
        while (divisor > 0) {
            if (number % divisor == 0) {
                return divisor;
            }
            divisor--;
        }
        return 1; // In case no divisor is found, return 1 (though logically unreachable for number > 1)
    }
}