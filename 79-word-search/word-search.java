class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public boolean dfs(int row, int col, int index, char[][] board, String word, boolean[][] vis) {
        if (index == word.length() - 1) return true;

        vis[row][col] = true;

        for (int k = 0; k < 4; k++) {
            int nRow = row + dx[k];
            int nCol = col + dy[k];

            if (nRow >= 0 && nRow < board.length &&
                nCol >= 0 && nCol < board[0].length &&
                !vis[nRow][nCol] &&
                board[nRow][nCol] == word.charAt(index + 1)) {

                if (dfs(nRow, nCol, index + 1, board, word, vis))
                    return true;
            }
        }

        vis[row][col] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, 0, board, word, vis))
                        return true;
                }
            }
        }

        return false;
    }
}