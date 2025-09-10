import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HumanEval_87 {
    public static List<int[]> getRow(List<List<Integer>> lst, int x) {
        List<int[]> coords = new ArrayList<>();
        
        for (int i = 0; i < lst.size(); i++) {
            for (int j = 0; j < lst.get(i).size(); j++) {
                if (lst.get(i).get(j) == x) {
                    coords.add(new int[]{i, j});
                }
            }
        }
        
        // Sort by column descending, then by row ascending
        Collections.sort(coords, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] != b[1]) {
                    return Integer.compare(b[1], a[1]); // Descending order for columns
                } else {
                    return Integer.compare(a[0], b[0]); // Ascending order for rows
                }
            }
        });
        
        return coords;
    }
}