class Solution {
    public int solve(int i,int j,int pref[],int dp[][]){
        if(i >= j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int ans=0;
        int res=0;
        for(int ind = i+1;ind <=j;ind++){
            int left=pref[ind] - pref[i];
            int right=pref[j+1] - pref[ind];

            if(left > right){
                ans=right + solve(ind,j,pref,dp);
            } 
            else if(left < right){
                ans=left + solve(i,ind-1,pref,dp);
            }
            else{
                ans=Math.max(right + solve(ind,j,pref,dp) , left + solve(i,ind-1,pref,dp));
            }
            res=Math.max(res,ans);
        }
        // System.out.println(" for i -> " + i +"and j ->"+j +"res ->" +res );
        return dp[i][j]=res;
    }
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        int pref[]=new int[n + 1];
       
        for(int i=1;i<=n;i++){
            pref[i]=pref[i-1] + stoneValue[i-1];
        }
        int dp[][]=new int[n][n];
        for(int arr[] : dp){
            Arrays.fill(arr,-1);
        }

        return solve(0,n-1,pref,dp);
    }
}