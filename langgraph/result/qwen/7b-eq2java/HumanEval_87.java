import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HumanEval_87 {

    public List<int[]> getRow(List<List<Integer>> lst, int x) {
        List<int[]> coords = new ArrayList<>();
        for (int row_index = 0; row_index < lst.size(); row_index++) {
            for (int col_index = 0; col_index < lst.get(row_index).size(); col_index++) {
                if (lst.get(row_index).get(col_index) == x) {
                    coords.add(new int[]{row_index, col_index});
                }
            }
        }

        Collections.sort(coords, new Comparator<int[]>() {
            @Override
            public int compare(int[] pos1, int[] pos2) {
                return Integer.compare(pos2[1], pos1[1]);
            }
        });

        Collections.sort(coords, new Comparator<int[]>() {
            @Override
            public int compare(int[] pos1, int[] pos2) {
                return Integer.compare(pos1[0], pos2[0]);
            }
        });

        return coords;
    }
}