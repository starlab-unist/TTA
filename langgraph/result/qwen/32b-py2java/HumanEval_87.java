import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class HumanEval_87 {
    public List<int[]> getRow(List<List<Integer>> lst, int x) {
        List<int[]> coords = new ArrayList<>();
        for (int i = 0; i < lst.size(); i++) {
            for (int j = 0; j < lst.get(i).size(); j++) {
                if (lst.get(i).get(j) == x) {
                    coords.add(new int[]{i, j});
                }
            }
        }
        
        Collections.sort(coords, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                } else {
                    return Integer.compare(b[1], a[1]);
                }
            }
        });
        
        return coords;
    }
}