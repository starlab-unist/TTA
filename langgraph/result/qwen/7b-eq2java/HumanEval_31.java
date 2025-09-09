public class HumanEval_31 {
    public static boolean check_prime(int number) {
        if (number < 2) {
            return false;
        }
        int divisor = 2;
        while (divisor < number - 1) {
            if (number % divisor == 0) {
                return false;
            }
            divisor += 1;
        }
        return true;
    }
}