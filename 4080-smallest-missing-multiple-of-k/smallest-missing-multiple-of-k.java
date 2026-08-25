class Solution {
    public int missingMultiple(int[] nums, int k) {
       HashSet<Integer> set=new HashSet<>();
       for(int num : nums){
        if(num % k ==0) set.add(num);
       } 
       int n=nums.length;
       int idx=1;
       while(idx <= n){
        if(!set.contains(k * idx)) return k*idx;
        idx++;
       }
       return idx * k;

    }
}