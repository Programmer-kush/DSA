class Solution {
    public int solve(int i,int j,int piles[],int dp[][]){
        if(i > j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        int a=solve(i+1,j-1,piles,dp);
        int b=solve(i+2,j,piles,dp);
        int c=solve(i,j-2,piles,dp);
        int first=piles[i] + Math.min(a,b);
        int last=piles[j] + Math.min(a,c);

        return dp[i][j]=Math.max(first,last);
    }
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        int dp[][]=new int[n][n];
        for(int arr[] : dp) Arrays.fill(arr,-1);
        int alice=solve(0,n-1,piles,dp);
        int sum=0;
        for(int num : piles) sum+=num;
        return (alice > sum-alice);
    }
}