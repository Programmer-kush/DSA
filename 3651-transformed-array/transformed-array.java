class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            int val=nums[i];
            if(val==0) continue;
            if(val >0){
                arr[i]=nums[(val + i) % n];
            }
            else{
                int index=(i + val)%n;
                
                
                if(index >0) arr[i]=nums[index];
                else{
                    if(index==0) arr[i]=nums[0];
                    else arr[i]=nums[n+index];
                }
            }
        }
        return arr;
    }
}