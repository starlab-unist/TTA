public class HumanEval_44 {

    public static String changeBase(int x, int base) {
        StringBuilder ret = new StringBuilder();
        while (x > 0) {
            ret.insert(0, x % base);
            x /= base;
        }
        return ret.toString();
    }

}