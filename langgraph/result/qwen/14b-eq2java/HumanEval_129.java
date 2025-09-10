import java.util.ArrayList;
import java.util.List;

public class HumanEval_129 {
    public static List<Integer> findMinimumPathValues(int[][] matrix, int count) {
        int size = matrix.length;
        int minimumValue = size * size + 1;
        
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col] == 1) {
                    List<Integer> neighbors = new ArrayList<>();
                    if (row > 0) {
                        neighbors.add(matrix[row - 1][col]);
                    }
                    if (col > 0) {
                        neighbors.add(matrix[row][col - 1]);
                    }
                    if (row < size - 1) {
                        neighbors.add(matrix[row + 1][col]);
                    }
                    if (col < size - 1) {
                        neighbors.add(matrix[row][col + 1]);
                    }
                    
                    for (int neighbor : neighbors) {
                        if (neighbor < minimumValue) {
                            minimumValue = neighbor;
                        }
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int index = 0;
        while (index < count) {
            if (index % 2 == 0) {
                result.add(1);
            } else {
                result.add(minimumValue);
            }
            index++;
        }

        return result;
    }
}