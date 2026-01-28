class Solution {
    public boolean possible(int size,int nums[],int target){
        int sum=0;
        int n=nums.length;

        int left=0;
        int right=0;

        for(right=0;right<size;right++){
            sum+=nums[right];

        }
  
        if(sum >= target) return true;
        while(right < n){
            sum=sum + nums[right] - nums[left];
            if(sum >= target) return true;
            right++;
            left++;
            
        }
        return false;

    }
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int low=1;
        int high=n;

        while(low<=high){
            int mid=(low + high)>>1;
            if(possible(mid,nums,target)){
                //System.out.println("iss mid pe true hua "+ mid);
                high=mid-1;
            }
            else low=mid + 1;

        }
            if(low > n) return 0;
            return low;
    }
}