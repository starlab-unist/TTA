import java.util.ArrayList;
import java.util.List;

public class HumanEval_130 {
    public List<Double> tri(int n) {
        if (n == 0) {
            List<Double> result = new ArrayList<>();
            result.add(1.0);
            return result;
        }
        List<Double> myTri = new ArrayList<>();
        myTri.add(1.0);
        myTri.add(3.0);
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                myTri.add((double) i / 2 + 1);
            } else {
                myTri.add(myTri.get(i - 1) + myTri.get(i - 2) + (double) (i + 3) / 2);
            }
        }
        return myTri;
    }
}