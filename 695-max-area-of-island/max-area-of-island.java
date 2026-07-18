class Solution {
    int dx[]={0,0,1,-1};
    int dy[]={1,-1,0,0};
    public void dfs(int row,int col,int [][]grid,boolean visited[][],int count[]){
        visited[row][col]=true;
        count[0]++;
        for(int k=0;k<4;k++){
            int nRow=row+dx[k];
            int nCol=col + dy[k];

            if(nRow >=0 && nRow < grid.length && nCol>=0 && nCol < grid[0].length){
                if(!visited[nRow][nCol] && grid[nRow][nCol]==1) dfs(nRow,nCol,grid,visited,count);
            }
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        boolean visited[][]=new boolean[m][n];
        int count[]={0};
        int ans=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    dfs(i,j,grid,visited,count);
                    ans=Math.max(ans,count[0]);
                    count[0]=0;
                }
            }
        }

        return ans;
        
    }
}