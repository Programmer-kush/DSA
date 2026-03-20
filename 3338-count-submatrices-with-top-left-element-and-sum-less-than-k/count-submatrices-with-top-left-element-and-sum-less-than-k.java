class Solution {
    public int countSubmatrices(int[][] grid, int k) {
      int m=grid.length;
      int n=grid[0].length;

      int temp[][]=new int[m][n];
      //temp[0][0]=grid[0][0];

      for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            temp[i][j]=grid[i][j];
            if(i>0) temp[i][j]+=temp[i-1][j];
            if(j>0) temp[i][j]+=temp[i][j-1];
            if(i>0 && j>0) temp[i][j]-=temp[i-1][j-1];
        }
      }
      int count=0;
      for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(temp[i][j] <= k) count++;
        }
      }
      return count;
    }
}