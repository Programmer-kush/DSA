class Solution {
    public boolean possible(int mid,int bloomDay[],int m,int k){
        int count=0;
        int consecutives=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i] <= mid){
                consecutives++;
                if(consecutives == k){
                    count++;
                    consecutives=0;
                }
            }
            else{
                consecutives=0;
            }
        }
        return (count >= m);
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        int low=0;
        int high=0;
        for(int num : bloomDay){
            high=Math.max(high,num);
        }
        

        if(1L*k * m > 1L * n) return -1;

        while(low<= high){
            int mid=low + ((high-low)>>1);
            if(possible(mid,bloomDay,m,k)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        
        return low;
    }
}