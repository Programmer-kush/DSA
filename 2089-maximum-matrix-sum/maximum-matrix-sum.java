class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0;
        int n=matrix.length;

        int min=Integer.MAX_VALUE;
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int val=matrix[i][j];
                if(val < 0){
                    count++;
                }
                min=Math.min(min,Math.abs(val));

                sum+=Math.abs(val);
            }
        }

        if(count%2==0) min=0;
        return sum - Math.abs(2 * min);
   



    }
}