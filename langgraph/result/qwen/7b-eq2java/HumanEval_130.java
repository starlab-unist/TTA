import java.util.ArrayList;
import java.util.List;

public class HumanEval_130 {
    public static List<Double> generateCustomSequence(int n) {
        if (n == 0) {
            List<Double> result = new ArrayList<>();
            result.add(1.0);
            return result;
        }
        
        List<Double> myTri = new ArrayList<>();
        myTri.add(1.0);
        myTri.add(3.0);
        int i = 2;
        
        while (i <= n) {
            if (i % 2 == 0) {
                myTri.add(i / 2.0 + 1);
            } else {
                myTri.add(myTri.get(i - 1) + myTri.get(i - 2) + (i + 3) / 2.0);
            }
            i++;
        }
        
        return myTri;
    }
}