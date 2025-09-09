import java.util.ArrayList;
import java.util.List;

public class HumanEval_129 {
    public List<Integer> minPath(int[][] grid, int k) {
        int n = grid.length;
        int val = n * n + 1;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    List<Integer> neighbors = new ArrayList<>();
                    if (row > 0) {
                        neighbors.add(grid[row - 1][col]);
                    }
                    if (col > 0) {
                        neighbors.add(grid[row][col - 1]);
                    }
                    if (row < n - 1) {
                        neighbors.add(grid[row + 1][col]);
                    }
                    if (col < n - 1) {
                        neighbors.add(grid[row][col + 1]);
                    }
                    val = Math.min(val, neighbors.stream().min(Integer::compare).orElse(val));
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        int index = 0;
        while (index < k) {
            if (index % 2 == 0) {
                ans.add(1);
            } else {
                ans.add(val);
            }
            index++;
        }

        return ans;
    }
}