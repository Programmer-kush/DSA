class Solution {
    boolean isValid(int row,int col,int side,int x,int mat[][],int rowSum[][]){
        int sum=0;
       
        
        for(int i=row;i < row +side;i++){
            sum += rowSum[i][col + side -1] - (col > 0 ? rowSum[i][col - 1] : 0);
           
            if(sum > x) return false;
        }
        return true;
       
        
    }
    public int maxSideLength(int[][] mat, int threshold) {
        int m=mat.length;
        int n=mat[0].length;

        int rowSum[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int prefix=0;
                if(j > 0) prefix=rowSum[i][j-1];
                rowSum[i][j]=prefix + mat[i][j];
            }
        }

        for(int side=Math.min(m,n);side>=1;side--){
            for(int i=0;i + side<= m  ;i++){
                for(int j=0;j + side <=n;j++){
                    if(isValid(i,j,side,threshold,mat,rowSum)) return side;
                }
            }
        }

        return 0;
    }
}