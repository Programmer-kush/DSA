class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int x[][]=new int[m][n];
        int y[][]=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char ch=grid[i][j];
                if(i>0){
                    x[i][j]+=x[i-1][j];
                    y[i][j]+=y[i-1][j];
                }
                if(j>0){
                    x[i][j]+=x[i][j-1];
                    y[i][j]+=y[i][j-1];
                }
                if(i>0 && j>0){
                    x[i][j]-=x[i-1][j-1];
                    y[i][j]-=y[i-1][j-1];
                }
                if(ch=='X') x[i][j]++;
                if(ch=='Y') y[i][j]++;
            }
        }

        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(x[i][j]==0) continue;
                if(x[i][j]==y[i][j]) count++;
            }
        }
        return count;
    }
}