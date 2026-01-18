class Solution {

    boolean isValid(int row,int col,int side,int grid[][],int rowSum[][],int colSum[][]){
        int target=0;
        for(int i=row;i<row + side;i++){
            target+=grid[i][col];
        }

        boolean flag=true;
        //check all cols except the above
        for(int j=col + 1;j < col + side;j++){
            int colsum = colSum[row + side - 1][j]
           - (row > 0 ? colSum[row - 1][j] : 0);

            if(colsum != target) return false;
            
        }
        //now check rows
        for(int i=row;i<row + side;i++){
            int rowsum = rowSum[i][col + side - 1]
           - (col > 0 ? rowSum[i][col - 1] : 0);

            if(rowsum != target) return false;
        }

        //now check diagonal
        int rowIndex=row + side -1;
        int colIndex=col;
        int diagonalSum=0;
        while(rowIndex >= row && colIndex < col +side){
            diagonalSum+=grid[rowIndex][colIndex];
            rowIndex--;
            colIndex++;
        }
        if(diagonalSum!=target) return false;
        diagonalSum=0;
        rowIndex=row;
        colIndex=col;
        while(rowIndex < row + side && colIndex < col +side){
            diagonalSum+=grid[rowIndex][colIndex];
            rowIndex++;
            colIndex++;
        }
        if(diagonalSum!=target) return false;
        return true;
        
    }
 
    public int largestMagicSquare(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int rowSum[][]=new int[m][n];
        int colSum[][]=new int[m][n];

        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                int prefix=0;
                if(col > 0)prefix=rowSum[row][col -1 ];
                rowSum[row][col]= prefix + grid[row][col];
            }
        }

        for(int col=0;col<n;col++){
            for(int row=0;row<m;row++){
                int prefix=0;
                if(row > 0) prefix=colSum[row-1][col];
                colSum[row][col]=prefix + grid[row][col];
            }
        }

       for(int side=Math.min(m,n);side>=2;side--){
            for(int i=0;i + side <= m;i++ ){
                for(int j=0;j + side <= n;j++){
                    if(isValid(i,j,side,grid,rowSum,colSum)) return side;
                }
            }
       }
        return 1;

        
    }
}