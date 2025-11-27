class Solution {
    int mod = (int)1e9 + 7;
    Integer[][][] dp;

    int solve(int r,int c,int rem,int k,int[][] g){
        if(r==g.length-1 && c==g[0].length-1)
            return ((rem + g[r][c]) % k)==0 ? 1 : 0;

        if(dp[r][c][rem] != null) return dp[r][c][rem];

        int newRem = (rem + g[r][c]) % k;
        long ans = 0;

        if(r+1 < g.length) ans += solve(r+1,c,newRem,k,g);
        if(c+1 < g[0].length) ans += solve(r,c+1,newRem,k,g);

        return dp[r][c][rem] = (int)(ans % mod);
    }

    public int numberOfPaths(int[][] grid, int k) {
        dp = new Integer[grid.length][grid[0].length][k];
        return solve(0,0,0,k,grid);
    }
}
