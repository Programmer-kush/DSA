class Solution {
    public int digit(int num){
        int ans=0;
        while(num!=0){
            ans+=num%10;
            num/=10;
        }
        return ans;
    }
    public int minElement(int[] nums) {
        int min=(int)1e8;
        for(int num : nums){
            min=Math.min(min,digit(num));
        }

        return min;
    }
}