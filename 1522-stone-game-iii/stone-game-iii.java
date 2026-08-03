class Solution {
    Integer[] dp;

    public int solve(int i, int[] stoneValue) {
        if (i >= stoneValue.length) return 0;

        if (dp[i] != null) return dp[i];

        int sum = 0;
        int ans = Integer.MIN_VALUE;

        for (int k = 0; k < 3 && i + k < stoneValue.length; k++) {
            sum += stoneValue[i + k];
            ans = Math.max(ans, sum - solve(i + k + 1, stoneValue));
        }

        return dp[i] = ans;
    }

    public String stoneGameIII(int[] stoneValue) {
        dp = new Integer[stoneValue.length];
        int diff = solve(0, stoneValue);

        if (diff > 0) return "Alice";
        if (diff < 0) return "Bob";
        return "Tie";
    }
}