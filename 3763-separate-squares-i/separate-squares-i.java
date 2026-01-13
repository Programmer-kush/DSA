class Solution {

    public double area(double mid,int squares[][]){
        double ans=0;
        for(int i=0;i<squares.length;i++){
            int center=squares[i][1];
            if(center > mid) break;

            
            double side=squares[i][2];
            if(center + squares[i][2] <= mid){
                ans += side * side;
            }
            else{
                ans+= (mid - (double)squares[i][1]) *side;
            }
        }
        return ans;
    }

    public double separateSquares(int[][] squares) {
        Arrays.sort(squares, (a,b)-> a[1] - b[1]);
        double total_area=0;

        double low=(double)1e9;
        double high=0;

        for(int i=0;i<squares.length;i++){
            double side = squares[i][2];
            total_area+=side * side;
            high=Math.max(high,squares[i][1] + squares[i][2]);
            low=Math.min(low,squares[i][1]);
        }
        System.out.println("low" + low);
        System.out.println("high" + high);
        System.out.println(total_area);

        while(high - low >= 1e-5){
            double mid=(low + high)/2;
            double area_below=area(mid,squares);
            System.out.println(area_below);
            double area_above=total_area-area_below;

            if(area_below >= area_above){
                high = mid;

            }
            else low=mid;
        }
        return low;
    }
}