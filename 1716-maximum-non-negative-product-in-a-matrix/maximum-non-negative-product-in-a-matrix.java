import java.util.*;

class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long mod = 1_000_000_007;

        // Use long to avoid overflow before the final modulo
        long[][] maxDP = new long[m][n];
        long[][] minDP = new long[m][n];

        // Initialize the starting cell
        maxDP[0][0] = minDP[0][0] = grid[0][0];

        // Fill the first column
        for (int i = 1; i < m; i++) {
            maxDP[i][0] = minDP[i][0] = maxDP[i - 1][0] * grid[i][0];
        }

        // Fill the first row
        for (int j = 1; j < n; j++) {
            maxDP[0][j] = minDP[0][j] = maxDP[0][j - 1] * grid[0][j];
        }

        // Fill the rest of the DP tables
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] >= 0) {
                    maxDP[i][j] = Math.max(maxDP[i - 1][j], maxDP[i][j - 1]) * grid[i][j];
                    minDP[i][j] = Math.min(minDP[i - 1][j], minDP[i][j - 1]) * grid[i][j];
                } else {
                    // If current number is negative, max becomes min * negative and vice versa
                    maxDP[i][j] = Math.min(minDP[i - 1][j], minDP[i][j - 1]) * grid[i][j];
                    minDP[i][j] = Math.max(maxDP[i - 1][j], maxDP[i][j - 1]) * grid[i][j];
                }
            }
        }

        long res = maxDP[m - 1][n - 1];
        
        // If the max product is negative, the problem asks to return -1
        return res < 0 ? -1 : (int) (res % mod);
    }
}