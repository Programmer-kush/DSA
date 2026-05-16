class Solution {
    public int findMin(int[] nums) {
        int min=(int)1e8;
        for(int num : nums) min=Math.min(min,num);
        return min;
    }
}