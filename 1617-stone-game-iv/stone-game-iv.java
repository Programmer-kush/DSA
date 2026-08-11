class Solution {
    public boolean solve(int n,Boolean dp[]){
        if(n<=0) return false;
        if(dp[n] !=null) return dp[n];

        for(int i=1;i*i <= n;i++){
            boolean opp=solve(n - i*i,dp);
            if(opp==false) return dp[n]=true;
        }
        return dp[n]=false;
    }
    public boolean winnerSquareGame(int n) {
        Boolean dp[]=new Boolean[n+1];
        for(int j=1;j<=n;j++){
            for(int i=1;i*i <= j;i++){
                boolean opp=solve(j - i*i,dp);
                if(opp==false){
                  dp[j]=true;
                }
                    
            }
             if(dp[j]==null)dp[j]=false;
        }
       // return solve(n,dp);
        return dp[n];

    }
}