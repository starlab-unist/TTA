public class HumanEval_159 {
    public static int[] consume(int quantity, int requirement, int stock) {
        int updatedQuantity;
        int leftoverStock;

        if (requirement <= stock) {
            updatedQuantity = quantity + requirement;
            leftoverStock = stock - requirement;
        } else {
            updatedQuantity = quantity + stock;
            leftoverStock = 0;
        }

        return new int[]{updatedQuantity, leftoverStock};
    }
}