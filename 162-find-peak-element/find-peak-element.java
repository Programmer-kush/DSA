class Solution {
    public int findPeakElement(int[] nums) {
        
        int n=nums.length;
        if(n==1) return 0;
        int low=0;
        int high=n-1;

        while(low <= high){
            int mid=(low + high) /2;
            int right=(mid+1 >= n)?Integer.MIN_VALUE : nums[mid+1];
            int left=(mid-1 < 0) ?Integer.MIN_VALUE : nums[mid-1];

            if(nums[mid] > right && nums[mid] > left) return mid;
            else if(nums[mid] < right) low=mid+1;
            else high=mid-1; 
        }
        return -1;
    }
}