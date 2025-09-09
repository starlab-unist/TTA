import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HumanEval_87 {

    public List<int[]> findCoordinates(int[][] matrix, int target) {
        List<int[]> positions = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int colIndex = 0; colIndex < matrix[rowIndex].length; colIndex++) {
                if (matrix[rowIndex][colIndex] == target) {
                    positions.add(new int[]{rowIndex, colIndex});
                }
            }
        }

        Collections.sort(positions, Comparator.comparingInt(pos -> pos[1]));
        Collections.sort(positions, Comparator.comparingInt(pos -> pos[0]));

        return positions;
    }
}