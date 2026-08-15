class Solution {
    public int longestSubsequence(int[] nums) {
        int xor=0;
        int n=nums.length;
        boolean non_zero=false;
        for(int num : nums){
            xor=xor  ^ num;
            if(num !=0) non_zero=true;
        }
        if(xor != 0) return n;
        if(non_zero) return n-1;
        return 0;
    }
}