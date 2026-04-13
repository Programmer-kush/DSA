class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n=nums.length;
        int min=(int)1e8;

        for(int i=start;i<n;i++){
            if(nums[i]==target){
                min=i-start;
                break;
            }
        }

        for(int i=start-1;i>=0;i--){
            if(nums[i]==target){
                int temp=start-i;
                min=Math.min(min,temp);
                break;
            }
        }

        return min;
    }
}