import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        List<int[]> sortedPositions = positions.stream()
                .sorted((pos1, pos2) -> Integer.compare(pos2[1], pos1[1]))
                .collect(Collectors.toList());

        List<int[]> finalSortedPositions = sortedPositions.stream()
                .sorted((pos1, pos2) -> Integer.compare(pos1[0], pos2[0]))
                .collect(Collectors.toList());

        return finalSortedPositions;
    }
}