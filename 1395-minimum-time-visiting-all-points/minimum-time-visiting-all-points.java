class Solution {
    public int distance(int x1,int y1,int x2,int y2){
        int temp1=x1-x2;
        temp1*=temp1;

        int temp2=y1-y2;
        temp2*=temp2;

        int ans=temp1+temp2;
        return (int) Math.sqrt(ans);
    }
    public int minTimeToVisitAllPoints(int[][] points) {
        int total=0;


        for(int i=0;i<points.length-1;i++){
            int x1=points[i][0];
            int x2=points[i+1][0];

            int y1=points[i][1];
            int y2=points[i+1][1];

            int x_distance=Math.abs(x1-x2);
            int y_distance=Math.abs(y1-y2);
            total+=Math.max(x_distance,y_distance);
        }
        return total;
    }
}