class Solution {
    
    int solve(int i,int j,int nums1[],int nums2[],int dp[][]){
       if (i == nums1.length || j == nums2.length) {
            return Integer.MIN_VALUE;
        }

        if(dp[i][j]!=Integer.MIN_VALUE) return dp[i][j];

        int not_take=Math.max(solve(i+1,j,nums1,nums2,dp),solve(i,j+1,nums1,nums2,dp));
        int take = nums1[i]*nums2[j] + Math.max(0, solve(i+1,j+1,nums1,nums2,dp));

        dp[i][j]=Math.max(take,not_take);
        return dp[i][j];
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n1=nums1.length,n2=nums2.length;
        int dp[][]=new int[n1][n2];
        for(int[] row : dp){
            Arrays.fill(row,Integer.MIN_VALUE);
        }
        return solve(0,0,nums1,nums2,dp);
    }
}