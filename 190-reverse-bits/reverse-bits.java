class Solution {
    public int reverseBits(int n) {
        int ans=0;
         for(int i=0;i<32;i++){
            int bit=n&1;
            n=n>>1;
            ans+=(int) Math.pow(2,31-i) * bit;
         }
         return ans;
    }
}