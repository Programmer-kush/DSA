class Solution {

    public boolean checkSimilar(String s,String w){
        int n=s.length();
        char[] sArr=s.toCharArray();
        char[] wArr=w.toCharArray();

        int count=0;

        for(int i=0;i<n;i++){
            if(sArr[i] != wArr[i]) count++;

            if(count > 2) return false;
        }
        return true;
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        HashSet<String> set=new HashSet<>();
        for( String s : dictionary){
            set.add(s);
        }

        List<String> ans=new ArrayList<>();
        for(String s : queries){
            if(set.contains(s)){
                ans.add(s);
                continue;
            }

            for(String w : dictionary){
                if(checkSimilar(s,w)){
                    ans.add(s);
                    break;
                }
            }
        }

        return ans;
    }
}