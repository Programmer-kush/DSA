class Solution {
    public int smallestRepunitDivByK(int k) {
        int length=1;

        int rem=0;
        int num=1;

        for(int i=1;i<=k;i++){
            rem=num%k;
            num=rem*10 + 1;
            if(rem==0){
                return length;
            }
            length++;
        }
        return -1;
    }
}