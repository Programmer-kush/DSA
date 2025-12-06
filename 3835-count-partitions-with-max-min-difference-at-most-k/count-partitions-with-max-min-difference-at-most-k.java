import java.util.*;

class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        int MOD =(int)1e9+7;

        // dp[i] = number of ways to partition prefix nums[0..i-1]
        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];  // prefix sum of dp

        dp[0] = 1;
        prefix[0] = 1;

        // deques to maintain current window min and max
        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            int x = nums[right];

            // maintain increasing deque for min
            while (!minQ.isEmpty() && nums[minQ.peekLast()] > x) {
                minQ.pollLast();
            }
            minQ.offerLast(right);

            // maintain decreasing deque for max
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] < x) {
                maxQ.pollLast();
            }
            maxQ.offerLast(right);

            // shrink window from left if invalid
            while (!minQ.isEmpty() && !maxQ.isEmpty() &&
                   nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k) {
                if (minQ.peekFirst() == left) minQ.pollFirst();
                if (maxQ.peekFirst() == left) maxQ.pollFirst();
                left++;
            }

            // Now valid window is [left..right]. Any segment starting at j in [left..right] 
            // and ending at right is valid. That means dp[right+1] = sum(dp[left..right])
            long sum = prefix[right] - (left > 0 ? prefix[left - 1] : 0);
            dp[right + 1] = (sum % MOD + MOD) % MOD;
            prefix[right + 1] = (prefix[right] + dp[right + 1]) % MOD;
        }

        return (int) dp[n];
    }
}
