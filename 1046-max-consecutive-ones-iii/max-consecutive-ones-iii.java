class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen=0;

        int left=0;

        int curr=0;

        for(int right=0;right<nums.length;right++){
            if(nums[right]==1) curr++;

            if(right-left+1 - curr > k){
                if(nums[left]==1) curr--;
                left++; 
            }
            if(right - left +1 -curr <=k){
                maxLen=Math.max(maxLen,right-left+1);
            }
        }

        return maxLen;
    }
}