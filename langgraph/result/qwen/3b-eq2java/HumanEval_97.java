public class HumanEval_97 {

    public static int calculateUnitDigitProduct(int x, int y) {
        int unitDigitX = Math.abs(x % 10);
        int unitDigitY = Math.abs(y % 10);
        int product = unitDigitX * unitDigitY;
        return product;
    }
}