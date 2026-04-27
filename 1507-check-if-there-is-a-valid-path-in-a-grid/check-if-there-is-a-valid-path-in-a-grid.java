class Solution {
    public boolean hasValidPath(int[][] grid) {
        
        int[][][] dirs = {
            {},
            {{0,-1},{0,1}},   // 1
            {{-1,0},{1,0}},   // 2
            {{0,-1},{1,0}},   // 3
            {{0,1},{1,0}},    // 4
            {{0,-1},{-1,0}},  // 5
            {{0,1},{-1,0}}    // 6
        };

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            if(r == m-1 && c == n-1) return true;

            int val = grid[r][c];

            for(int[] d : dirs[val]){
                int nRow = r + d[0];
                int nCol = c + d[1];

                if(nRow < 0 || nCol < 0 || nRow >= m || nCol >= n) continue;
                if(visited[nRow][nCol]) continue;

                int newVal = grid[nRow][nCol];

                // check reverse connection
                for(int[] back : dirs[newVal]){
                    if(nRow + back[0] == r && nCol + back[1] == c){
                        visited[nRow][nCol] = true;
                        q.add(new int[]{nRow, nCol});
                        break;
                    }
                }
            }
        }

        return false;
    }
}