class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int max=0;

        int n=moves.length();

        //left wala
        int dist=0;
        for(int i=0;i<n;i++){
            char ch=moves.charAt(i);
            if(ch=='R') dist--;
            else dist++;
        }
        max=Math.max(max,dist);
        dist=0;
        for(int i=0;i<n;i++){
            char ch=moves.charAt(i);
            if(ch=='L') dist--;
            else dist++;
        }
        max=Math.max(max,dist);
        return max;
    }
}