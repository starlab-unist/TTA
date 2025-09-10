import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HumanEval_87 {
    public static List<int[]> findCoordinates(int[][] matrix, int target) {
        List<int[]> positions = new ArrayList<>();
        
        for (int row_index = 0; row_index < matrix.length; row_index++) {
            for (int col_index = 0; col_index < matrix[row_index].length; col_index++) {
                if (matrix[row_index][col_index] == target) {
                    positions.add(new int[]{row_index, col_index});
                }
            }
        }
        
        // Sort by column index in descending order
        Collections.sort(positions, new Comparator<int[]>() {
            @Override
            public int compare(int[] pos1, int[] pos2) {
                return Integer.compare(pos2[1], pos1[1]);
            }
        });
        
        // Then sort by row index in ascending order
        Collections.sort(positions, new Comparator<int[]>() {
            @Override
            public int compare(int[] pos1, int[] pos2) {
                return Integer.compare(pos1[0], pos2[0]);
            }
        });
        
        return positions;
    }
}