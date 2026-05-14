class Solution {
    public boolean isGood(int[] nums) {
        int base=nums.length-1;
        int arr[]=new int[base+1];
        for(int num : nums){
            if(num > base) return false;
            arr[num]++;
            if(arr[num] >= 2  && num != base) return false; 
            if(arr[num] >2) return false;
        }

        for(int i=1;i<arr.length;i++){
            if(arr[i]==0) return false;
        }
        return(arr[base]==2);
    }
}