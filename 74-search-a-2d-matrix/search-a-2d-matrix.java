class Solution {
    public boolean bs(int row,int matrix[][],int target){
        int low=0;
        int high=matrix[0].length;

        while(low <= high){
            int mid=low + (high-low)/2;
            if(matrix[row][mid]==target) return true;
            else if(matrix[row][mid] > target) high=mid-1;
            else low=mid+1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;

        int low=0;
        int high=m-1;

        while( low <=high){
            int mid=low + (high-low)/2;

            if(matrix[mid][0] <= target && matrix[mid][n-1] >= target){
                return bs(mid,matrix,target);
            }
            else if(matrix[mid][0] > target){
                high=mid-1;
            }
            else low=mid+1;
        }

        return false;
    }
}