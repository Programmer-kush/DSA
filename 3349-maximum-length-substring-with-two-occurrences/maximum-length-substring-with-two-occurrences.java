class Solution {
    public int maximumLengthSubstring(String s) {
        int ans=0;
        int left=0;
        HashMap<Character,Integer> map=new HashMap<>();

        for(int right=0;right<s.length();right++){
            Character c=s.charAt(right);
            map.put(c,map.getOrDefault(c,0) +1);

            while(map.get(c) > 2){
                Character l=s.charAt(left);
                int freq=map.get(l);
                freq--;
                map.put(l,freq);
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }

        return ans;
    }
}