class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int dfs(int row, int col, int[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0)
            return 0;

        grid[row][col] = 0;

        int area = 1;
        for (int k = 0; k < 4; k++) {
            area += dfs(row + dx[k], col + dy[k], grid);
        }

        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(i, j, grid));
                }
            }
        }

        return ans;
    }
}