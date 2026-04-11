class Solution {
    public int minimumDistance(int[] nums) {
        int n=nums.length;
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();

        int ans=(int)1e9;
        for(int i=0;i<n;i++){
            int num=nums[i];
            if(!map.containsKey(num)) map.put(num,new ArrayList<>());

            map.get(num).add(i);

            if(map.get(num).size() >=  3){
                ArrayList<Integer> list=map.get(num);
                int size=list.size();
        
                int j=list.get(size-2);
                int k=list.get(size-3);
                int diff=Math.abs(i-j) + Math.abs(j-k) + Math.abs(i-k);
                ans=Math.min(ans,diff);
            }
        }

        return ans==(int)1e9?-1:ans;
    }
}