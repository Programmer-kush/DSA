class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) ->b[0]-a[0]);
        for(int i=0;i<points.length;i++){
            int x=points[i][0];
            int y=points[i][1];
            int dist=x*x + y*y;
            pq.add(new int[]{dist,i});
            
            if(pq.size() > k) pq.poll();
        }

        int ans[][]=new int[k][2];
        int ind=0;
        while(!pq.isEmpty()){
            int i=pq.poll()[1];
            ans[ind][0]=points[i][0];
            ans[ind++][1]=points[i][1];
        }
        return ans;
    }
}