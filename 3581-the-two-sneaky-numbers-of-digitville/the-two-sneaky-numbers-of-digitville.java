class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length - 2;  // original 0..n-1 range
        int[] result = new int[2];
        int[] count = new int[n + 1];
        int idx = 0;
        for (int x : nums) {
            count[x]++;
            if (count[x] == 2) {
                result[idx++] = x;
                if (idx == 2) break;
            }
        }
        return result;
    }
}
