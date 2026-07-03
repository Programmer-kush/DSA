class Solution {

    class pair{
        int r,c,d;
        pair(int r,int c,int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }

    public void fill(int d[][],List<List<Integer>> grid){
        int n=grid.size();
        Queue<pair> q=new LinkedList<>();

           boolean visited[][]=new boolean[n][n];
        for(boolean arr[] : visited){
            Arrays.fill(arr,false);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j)==1){
                    q.add(new pair(i,j,0));
                    visited[i][j]=true;
                } 
                
            }
        }

     


        int dx[]={0,0,-1,1};
        int dy[]={1,-1,0,0};

        while(!q.isEmpty()){
            pair p=q.poll();
            int row=p.r;
            int col=p.c;
            int dist=p.d;

            d[row][col]=dist;

          

            for(int k=0;k<4;k++){
                int nRow=row+dx[k];
                int nCol=col+dy[k];

                if(nRow >=0 && nRow <n && nCol >=0 && nCol<n && !visited[nRow][nCol]){
                    q.add(new pair(nRow,nCol,dist+1));
                    visited[nRow][nCol]=true;
                }
            }
        }
    }

    boolean possible(int x,int d[][]){

        if(d[0][0]<x) return false;
        int n=d.length;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(0,0,d[0][0]));

        boolean visited[][]=new boolean[n][n];
        for(boolean arr[] : visited){
            Arrays.fill(arr,false);
        }
        visited[0][0]=true;
        
        int dx[]={0,0,-1,1};
        int dy[]={1,-1,0,0};

        while(!q.isEmpty()){
            pair p=q.poll();
            int row=p.r;
            int col=p.c;

            if(row==n-1 && col==n-1) return true;
            
            for(int k=0;k<4;k++){
                int nRow=row+dx[k];
                int nCol=col+dy[k];

                if(nRow>=0 && nRow<n && nCol>=0 && nCol<n && d[nRow][nCol] >= x && !visited[nRow][nCol]){
                    q.add(new pair(nRow,nCol,0));
                    visited[nRow][nCol]=true;
                }
            }

        }
        return false;

    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n=grid.size();

        if(grid.get(0).get(0)==1 || grid.get(n-1).get(n-1)==1) return 0;

        int d[][]=new int[n][n];
        for(int arr[] : d){
            Arrays.fill(arr,(int)1e8);
        }

        fill(d,grid);

        int low=0;
        int high=Math.min(d[0][0],d[n-1][n-1]);

        while(low<=high){
            int mid=(low+high)>>1;
            if(possible(mid,d)){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return high;
    }
}