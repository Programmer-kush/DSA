class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        HashSet<Integer> set=new HashSet<>();
        int MOD=(int)1e9 + 7;

        int[] horizontal = new int[hFences.length + 2];
        horizontal[0] = 1;
        horizontal[horizontal.length - 1] = m;
        System.arraycopy(hFences, 0, horizontal, 1, hFences.length);


        int[] vertical = new int[vFences.length + 2];
        vertical[0] = 1;
        vertical[vertical.length - 1] = n;
        System.arraycopy(vFences, 0, vertical, 1, vFences.length);
        
        for(int i=0;i<horizontal.length;i++){
            for(int j=i+1;j<horizontal.length;j++){
                set.add(Math.abs(horizontal[i] - horizontal[j]));
            }
        }

        int max=0;
        for(int i=0;i<vertical.length;i++){
            for(int j=i+1;j<vertical.length;j++){
                int side=Math.abs(vertical[i] - vertical[j]);
                if(set.contains(side)){
                    max=Math.max(max,side) %MOD;
                }
            }
        }
         if (max == 0) return -1;
        return (int)((1L * max * max) % MOD);

        
    }
}