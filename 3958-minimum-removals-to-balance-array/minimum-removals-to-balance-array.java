class Solution {
    
    public int minRemoval(int[] nums, int k) {
        int n=nums.length;
        if(n==1) return 0;
        Arrays.sort(nums);

        int i=0;
        int j=0;

        int ans=(int)1e9;

        while(j<n){
            long product=(long)nums[i]*k;
            if(product >= nums[j]){
                ans=Math.min(ans,(n- (j-i +1)));
            }
            else{
                i++;
            }
            j++;
        }

        return ans;
    }
}
