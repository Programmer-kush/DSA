class Solution {
    int solve(int num){
        int n=num;
        int pos=0;
        if(num==2) return -1;
        while(n > 0){
            if((n & 1)==1 && ((n>>1) & 1)==0){
                break;
            }
            n=n>>1;
            pos++;
        }
        System.out.println("pos for " + num + " is " + pos);

        return num ^ (1 << pos);
    }
    public int[] minBitwiseArray(List<Integer> nums) {
        int n=nums.size();
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=solve(nums.get(i));
        }

        return ans;
    }
}

//01 from left to right pe flip the 1
