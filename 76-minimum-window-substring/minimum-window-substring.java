class Solution {
    public boolean areEqual(HashMap<Character,Integer> smap, HashMap<Character,Integer> tmap){
        if(smap.size() < tmap.size()) return false;

        for(char key : tmap.keySet()){
            if(!smap.containsKey(key)) return false;
            if(tmap.get(key) > smap.get(key)) return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int m=s.length();
        int n=t.length();

        if(n > m) return "";

        HashMap<Character,Integer> tmap=new HashMap<>();
        HashMap<Character,Integer> smap=new HashMap<>();

        int left=0;
        int start=-1,end=-1;

        int len=(int)1e8;

        for(int i=0;i<n;i++){
            char ch=t.charAt(i);
            tmap.put(ch,tmap.getOrDefault(ch,0) + 1);
        }

        for(int right =0 ;right < m; right++){
            smap.put(s.charAt(right),smap.getOrDefault(s.charAt(right),0) + 1);

            while(areEqual(smap,tmap)){

                if(right - left + 1 < len){
                    start=left;
                    end=right;
                    len=right-left+1;
                }
                
                int l=smap.get(s.charAt(left));
                if(l==1) smap.remove(s.charAt(left));
                else smap.put(s.charAt(left),l-1);
                left++;
            }
        }
        if(start==-1 && end==-1) return "";
        return s.substring(start,end+1);
    }
}