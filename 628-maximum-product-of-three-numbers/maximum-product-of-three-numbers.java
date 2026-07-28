class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int ans=1;
        for(int i=nums.length-1;i>=nums.length-3;i--){
            ans=ans*nums[i];
        }
        int neg=1;
        int n=nums.length;
        neg=nums[0]*nums[1]*nums[n-1];
        return Math.max(ans,neg);
    }
}