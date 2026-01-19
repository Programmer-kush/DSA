// class Solution {
//     boolean isValid(int row,int col,int side,int x,int mat[][],int rowSum[][]){
//         int sum=0;
       
        
//         for(int i=row;i < row +side;i++){
//             sum += rowSum[i][col + side -1] - (col > 0 ? rowSum[i][col - 1] : 0);
           
//             if(sum > x) return false;
//         }
//         return true;
       
        
//     }
//     public int maxSideLength(int[][] mat, int threshold) {
//         int m=mat.length;
//         int n=mat[0].length;

//         int rowSum[][]=new int[m][n];
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 int prefix=0;
//                 if(j > 0) prefix=rowSum[i][j-1];
//                 rowSum[i][j]=prefix + mat[i][j];
//             }
//         }

//         int low=0;
//         int high=Math.min(m,n);
//         while(low <= high){
//             int side=(low + high)>>1;
//             for(int i=0;i + side<= m  ;i++){
//                 for(int j=0;j + side <=n;j++){
//                     if(isValid(i,j,side,threshold,mat,rowSum)) return side;
//                 }
//             }
//         }

//         return 0;
//     }
// }

class Solution {

    public int maxSideLength(int[][] matrix, int threshold) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] prefixSum = new int[rows + 1][cols + 1];

        // build 2D prefix sum
        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= cols; c++) {
                prefixSum[r][c] =
                        matrix[r - 1][c - 1]
                        + prefixSum[r - 1][c]
                        + prefixSum[r][c - 1]
                        - prefixSum[r - 1][c - 1];
            }
        }

        int left = 0;
        int right = Math.min(rows, cols);
        int answer = 0;

        while (left <= right) {
            int sideLength = left + (right - left) / 2;

            if (squareExists(prefixSum, sideLength, threshold, rows, cols)) {
                answer = sideLength;
                left = sideLength + 1;
            } else {
                right = sideLength - 1;
            }
        }

        return answer;
    }

    private boolean squareExists(int[][] prefixSum,
                                 int sideLength,
                                 int threshold,
                                 int rows,
                                 int cols) {

        for (int r = sideLength; r <= rows; r++) {
            for (int c = sideLength; c <= cols; c++) {
                int squareSum =
                        prefixSum[r][c]
                        - prefixSum[r - sideLength][c]
                        - prefixSum[r][c - sideLength]
                        + prefixSum[r - sideLength][c - sideLength];

                if (squareSum <= threshold) return true;
            }
        }
        return false;
    }
}
