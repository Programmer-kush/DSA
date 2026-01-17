class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long side=0;
        int n=bottomLeft.length;

        for(int i=0;i<n;i++){
            int x1=bottomLeft[i][0];
            int y1=bottomLeft[i][1];
            int x2=topRight[i][0];
            int y2=topRight[i][1];
            for(int j=i+1;j<n;j++){
                int temp1=bottomLeft[j][0];
                int temp2=bottomLeft[j][1];
                int temp3=topRight[j][0];
                int temp4=topRight[j][1];

                int finalX1=Math.max(x1,temp1);
                int finalY1=Math.max(y1,temp2);

                int finalX2=Math.min(x2,temp3);
                int finalY2=Math.min(y2,temp4);

                long width = finalX2 - finalX1;
                long height = finalY2 - finalY1;

                // 3. If they actually overlap, find the largest square that fits
                if (width > 0 && height > 0) {
                    long currentSide = Math.min(width, height);
                    side = Math.max(side, currentSide);
                }
                
            }
        }
        return side*side;
    }
}