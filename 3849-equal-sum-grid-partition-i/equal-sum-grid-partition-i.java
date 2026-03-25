class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        long sum=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sum+=(long) grid[i][j];
            }
        }

        //checking vertical
        long vertical=0;
        for(int j=0;j<n-1;j++){
            
            for(int i=0;i<m;i++){
                vertical+=grid[i][j];
            }
            if(vertical * 2 == sum) return true;
        }

        //checking horizontal
        long horizontal=0;
        for(int i=0;i<m-1;i++){
            for(int j=0;j<n;j++){
                horizontal+=grid[i][j];
            }
            if(horizontal * 2 == sum) return true;
        }

        return false;
    }
}