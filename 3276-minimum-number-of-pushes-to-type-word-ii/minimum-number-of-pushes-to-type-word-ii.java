class Solution {
    public int minimumPushes(String word) {
        Integer freq[]=new Integer[26];
        Arrays.fill(freq, 0);
        for(char c  : word.toCharArray()){
            freq[c-'a']++;
        }
       Arrays.sort(freq, Collections.reverseOrder());
        int ans=0;
        int k=1;
        for(int i=0;i<26;i++){
            if(i!=0 && i%8==0) k++;
            ans+=freq[i] * k;
        }
        return ans;
    }
}