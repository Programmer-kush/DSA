class Solution {
    public boolean possible(int mid,int nums[],int k){
        int count=1;
        int sum=0;
        for(int num : nums){
            sum+=num;
            if(sum > mid){
                sum=num;
                count++;
            }
        }
        return (count <= k);
    }
    public int splitArray(int[] nums, int k) {
        int low=0,high=0;
        for(int num : nums){
            low=Math.max(low,num);
            high+=num;
        }

        while(low <= high){
            int mid=low + (high-low)/2;

            if(possible(mid,nums,k)){
                high=mid-1;
            }
            else low=mid+1;
        }
        return low;
    }
}