class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int target = nums.get(i);
            int foundX = -1;

            // Search for the smallest x such that (x | (x + 1)) == target
            // Since we want the minimum x, we start from 0.
            for (int x = 0; x <= target; x++) {
                if ((x | (x + 1)) == target) {
                    foundX = x;
                    break; // Found the smallest, move to next num
                }
            }
            ans[i] = foundX;
        }

        return ans;
    }
}