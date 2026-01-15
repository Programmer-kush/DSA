class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int horizontals=n + 2;
        int verticals = m + 2;

        int height=0;
        int width=0;

        Arrays.sort(hBars);
        Arrays.sort(vBars);
        

        
        int side=2;

        int consecutive1[]=new int[hBars.length];
        int consecutive2[]=new int[vBars.length];
        consecutive1[0]=1;
        consecutive2[0]=1;

        for(int i=1;i<hBars.length;i++){
            if(hBars[i]==hBars[i-1]+1){
                consecutive1[i]=consecutive1[i-1]+1;
            }
            else consecutive1[i]=1;
        }
        for(int i=1;i<vBars.length;i++){
            if(vBars[i]==vBars[i-1]+1){
                consecutive2[i]=consecutive2[i-1]+1;
            }
            else consecutive2[i]=1;
        }
        
        Arrays.sort(consecutive1);
        Arrays.sort(consecutive2);

        int i = 0, j = 0;
        int max = 1;

        while (i < consecutive1.length && j < consecutive2.length) {
            if (consecutive1[i] == consecutive2[j]) {
                max = Math.max(max, consecutive1[i]);
                i++;
                j++;
            } else if (consecutive1[i] < consecutive2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return (max+1)*(max+1);

    }
}

