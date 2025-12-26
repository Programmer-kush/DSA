class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n=happiness.length;

        long sum=0;
        long count=0;

        for(int i=n-1;i>=n-k;i--){
            long val=happiness[i]-count;
            if(val<=0){
                break;
            }
            sum+=val;
            count++;
        }
        return sum;
    }
}