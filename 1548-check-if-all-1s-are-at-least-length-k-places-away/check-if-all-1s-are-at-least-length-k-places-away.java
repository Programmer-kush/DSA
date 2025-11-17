class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int first=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                break;
            }
            first++;
        }
        if(first==n) return true;
        int last=first;
        for(int i=first+1;i<n;i++){
            if(nums[i]==1){
                if((i-last)<=k) return false;
                last=i;
            }
        }

        return true;
    }
}