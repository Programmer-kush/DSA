class Solution {
    public int solve(int i,int j,int nums[],int dp[][]){
        if(i > j) return 0;

        if(dp[i][j] !=-1) return dp[i][j];

        int first=nums[i]  + Math.min(solve(i+2,j,nums,dp),solve(i+1,j-1,nums,dp));
        int last=nums[j] +  Math.min(solve(i+1,j-1,nums,dp),solve(i,j-2,nums,dp)); 

        return dp[i][j]=Math.max(first,last);
    }
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n];
        // for(int arr[] : dp){
        //     Arrays.fill(arr,-1);
        // }

        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                int first=nums[i];
                if(i+2 <n && j-1>=0) first+= Math.min(dp[i+2][j],dp[i+1][j-1]);
                int last=nums[j];
                if(i+1 < n && j-2>=0) last+=  Math.min(dp[i+1][j-1],dp[i][j-2]); 

                 dp[i][j]=Math.max(first,last);
            }
        }
        int player1=dp[0][n-1];
        int total=0;
        for(int num : nums) total += num;
        if(total%2==0){
            if(player1 == total/2) return true;
        }
            
        
        return (player1 > total/2);
    }
}