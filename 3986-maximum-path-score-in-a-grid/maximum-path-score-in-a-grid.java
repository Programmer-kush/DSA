class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        // dp[i][j][c] = max score from (i,j) to (m-1,n-1) with budget c remaining
        int[][][] dp = new int[m][n][k + 1];
        for (int[][] a : dp) for (int[] b : a) java.util.Arrays.fill(b, -1);

        // Base case: bottom-right cell
        for (int c = 0; c <= k; c++) {
            int cost = (grid[m-1][n-1] >= 1) ? 1 : 0;
            if (c >= cost) dp[m-1][n-1][c] = grid[m-1][n-1];
        }

        // Last column (can only go down)
        for (int i = m - 2; i >= 0; i--) {
            int cost = (grid[i][n-1] >= 1) ? 1 : 0;
            for (int c = 0; c <= k; c++) {
                if (c >= cost && dp[i+1][n-1][c - cost] != -1)
                    dp[i][n-1][c] = grid[i][n-1] + dp[i+1][n-1][c - cost];
            }
        }

        // Last row (can only go right)
        for (int j = n - 2; j >= 0; j--) {
            int cost = (grid[m-1][j] >= 1) ? 1 : 0;
            for (int c = 0; c <= k; c++) {
                if (c >= cost && dp[m-1][j+1][c - cost] != -1)
                    dp[m-1][j][c] = grid[m-1][j] + dp[m-1][j+1][c - cost];
            }
        }

        // Fill rest
        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                int cost = (grid[row][col] >= 1) ? 1 : 0;
                int cellScore = grid[row][col];
                for (int c = 0; c <= k; c++) {
                    if (c < cost) continue;
                    int down  = dp[row+1][col][c - cost];
                    int right = dp[row][col+1][c - cost];
                    int best = -1;
                    if (down  != -1) best = Math.max(best, cellScore + down);
                    if (right != -1) best = Math.max(best, cellScore + right);
                    dp[row][col][c] = best;
                }
            }
        }

        return dp[0][0][k];
    }
}