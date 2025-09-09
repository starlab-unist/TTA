class HumanEval_129 {
    public static int[] minPath(int[][] grid, int k) {
        int n = grid.length;
        int val = n * n + 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int[] temp = new int[4];
                    if (i != 0) {
                        temp[0] = grid[i - 1][j];
                    }

                    if (j != 0) {
                        temp[1] = grid[i][j - 1];
                    }

                    if (i != n - 1) {
                        temp[2] = grid[i + 1][j];
                    }

                    if (j != n - 1) {
                        temp[3] = grid[i][j + 1];
                    }

                    val = Integer.min(temp);
                }
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            if (i % 2 == 0) {
                ans[i] = 1;
            } else {
                ans[i] = val;
            }
        }
        return ans;
    }
}