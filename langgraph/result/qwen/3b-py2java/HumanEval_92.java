public class HumanEval_92 {

    public static boolean anyInt(int x, int y, int z) {
        if (x == y + z || x == z + y || y == x + z) {
            return true;
        }
        return false;
    }

}