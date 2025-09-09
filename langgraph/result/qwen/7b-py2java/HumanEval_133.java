import java.util.List;
import java.math.BigDecimal;

public class HumanEval_133 {
    public static int sumSquares(List<Double> lst) {
        int squared = 0;
        for (Double i : lst) {
            BigDecimal ceilValue = new BigDecimal(Math.ceil(i)).setScale(0, BigDecimal.ROUND_HALF_UP);
            squared += ceilValue.intValue() * ceilValue.intValue();
        }
        return squared;
    }
}