class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        long[] ans = new long[n];

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> indices = entry.getValue();
            int m = indices.size();

            // Build prefix sum of indices
            long[] prefix = new long[m + 1];
            for (int k = 0; k < m; k++) {
                prefix[k + 1] = prefix[k] + indices.get(k);
            }

            for (int k = 0; k < m; k++) {
                long idx = indices.get(k);
                long leftSum  = idx * k - prefix[k];           // sum of (idx - j) for j to the left
                long rightSum = (prefix[m] - prefix[k + 1]) - idx * (m - k - 1); // sum of (j - idx) for j to the right
                ans[(int) idx] = leftSum + rightSum;
            }
        }

        return ans;
    }
}