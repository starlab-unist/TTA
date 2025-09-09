import java.util.Iterator;

public class HumanEval_133 {
    public static int sumSquares(Iterator<Double> lst) {
        int squared = 0;
        while (lst.hasNext()) {
            double number = lst.next();
            squared += Math.ceil(number) * Math.ceil(number);
        }
        return squared;
    }
}