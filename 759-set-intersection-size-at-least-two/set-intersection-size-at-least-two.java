class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            if(a[1] != b[1]) return a[1] - b[1];
            return b[0] - a[0];
        });

        int p1 = -1, p2 = -1, count = 0;

        for(int[] it : intervals){
            int s = it[0], e = it[1];

            if(p2 < s){
                count += 2;
                p1 = e - 1;
                p2 = e;
            } 
            else if(p1 < s){
                count++;
                p1 = p2;
                p2 = e;
            }
        }

        return count;
    }
}
