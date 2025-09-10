public class HumanEval_159 {

    public static int[] consume(int quantity, int requirement, int stock) {
        if (requirement <= stock) {
            int updatedQuantity = quantity + requirement;
            int leftoverStock = stock - requirement;
            return new int[]{updatedQuantity, leftoverStock};
        } else {
            int updatedQuantity = quantity + stock;
            int leftoverStock = 0;
            return new int[]{updatedQuantity, leftoverStock};
        }
    }
}