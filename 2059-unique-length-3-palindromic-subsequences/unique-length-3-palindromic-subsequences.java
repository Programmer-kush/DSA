class Solution {
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        int[] first=new int[26];
        int[] last=new int[26];
        Arrays.fill(first,-1);
        Arrays.fill(last,-1);

        for(int i=0;i<n;i++){
            int c=s.charAt(i)-'a';
            if(first[c]==-1) first[c]=i;
            last[c]=i;
        }

        int ans=0;
        for(int c=0;c<26;c++){
            if(first[c]!=-1 && last[c]-first[c]>=2){
                boolean[] mid=new boolean[26];
                for(int i=first[c]+1;i<last[c];i++){
                    mid[s.charAt(i)-'a']=true;
                }
                int cnt=0;
                for(int k=0;k<26;k++){
                    if(mid[k]) cnt++;
                }
                ans+=cnt;
            }
        }
        return ans;
    }
}
