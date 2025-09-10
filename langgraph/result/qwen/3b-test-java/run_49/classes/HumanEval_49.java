public class HumanEval_49 {
    public static int calculateModularExponentiation(int baseCount, int modulus) {
        int result = 1;
        int index = 0;
        while (index < baseCount) {
            result = (2 * result) % modulus;
            index++;
        }
        return result;
    }
}