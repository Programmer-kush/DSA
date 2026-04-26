class Solution {
    class pair{
        int r,c,pRow,pCol;

        pair(int r,int c,int pRow,int pCol){
            this.r=r;
            this.c=c;
            this.pRow=pRow;
            this.pCol=pCol;
        }
    }

    boolean isCycle(int row,int col,char grid[][], boolean visited[][]){
        int m=grid.length;
        int n=grid[0].length;
        char ch=grid[row][col];
       

        Queue<pair> q=new LinkedList<>();
        q.add(new pair(row,col,-1,-1));
        visited[row][col]=true;

        int dx[]={-1,1,0,0};
        int dy[]={0,0,1,-1};
        int parentRow=-1,parentCol=-1;

        while(!q.isEmpty()){
            pair p=q.poll();
            int currRow=p.r;
            int currCol=p.c;
            int pRow=p.pRow;
            int pCol=p.pCol;

            for(int k=0;k<4;k++){
                int nRow=currRow + dx[k];
                int nCol=currCol + dy[k];

                if(nRow >=0 && nRow <m && nCol >=0 && nCol <n && grid[nRow][nCol]==ch){
                    if(nRow==pRow && nCol==pCol) continue;
                    if(visited[nRow][nCol]) return true;
                    q.add(new pair(nRow,nCol,currRow,currCol));
                    visited[nRow][nCol]=true;
                }
            }


        }

        return false;

    }
    public boolean containsCycle(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
         boolean visited[][]=new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if( !visited[i][j] && isCycle(i,j,grid,visited)) return true;
            }
        }

        return false;
    }
}