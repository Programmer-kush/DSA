class Solution {
    public int solve(int i,int pref[],int dp[]){
        if(i == pref.length-1) return pref[pref.length-1];
            if(dp[i] != -1) return dp[i];
            int take=pref[i]-solve(i+1,pref,dp);
            int skip=solve(i+1,pref,dp);

            return dp[i]= Math.max(take,skip);
      
    }
    public int stoneGameVIII(int[] stones) {
        int n=stones.length;
        int pref[]=new int[n];
        pref[0]=stones[0];
        for(int i=1;i<n;i++){
            pref[i]=stones[i] + pref[i-1];
        }
        int dp[]=new int[n+1];
        // Arrays.fill(dp,-1);
        dp[n-1]=pref[n-1];
        for(int i=n-2;i>=0;i--){
            int take=pref[i]-dp[i+1];
            int skip=dp[i+1];

             dp[i]= Math.max(take,skip);
        }

        return dp[1];
    }
}

// [7,-6,5,10,5,-2,-6,-7-,-7,-10]