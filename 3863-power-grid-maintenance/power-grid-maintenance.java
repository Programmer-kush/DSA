

class Solution {
    class disjointSet{
        int n;
        int parent[],size[];

        disjointSet(int n){
            this.n=n;
            parent=new int[n+1];
            size=new int[n+1];

            for(int i=1;i<=n;i++){
                parent[i]=i;
                size[i]=1;
            }

        }
        public int findParent(int x){
            if (parent[x] != x)
            parent[x] = findParent(parent[x]);  // path compression
            return parent[x];
        }
        public void union(int x,int y){
            int x_parent=findParent(x);
            int y_parent=findParent(y);
            if(x_parent==y_parent) return;

            if(size[x_parent] >= size[y_parent]){
                parent[y_parent]=x_parent;
                size[x_parent]+=size[y_parent];
            }
            else{
                parent[x_parent]=y_parent;
                size[x_parent]+=y_parent;
            }
        }
        boolean isConnected(int x,int y){
            return (findParent(x)==findParent(y));
        }
    }
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        int n=queries.length;
        
        disjointSet ds=new disjointSet(c);

        for(int[] con : connections){
            ds.union(con[0],con[1]);
        }
        
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();

        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true);

        for(int i=1;i<=c;i++){
            int p=ds.findParent(i);
            map.putIfAbsent(p,new TreeSet<>());
            map.get(p).add(i);
        }

        List<Integer> ans=new ArrayList<>();
        for(int[] q : queries){
            int type=q[0];
            int x=q[1];
            int parent=ds.findParent(x);

            if(type==1){
                if(online[x]){
                    ans.add(x);
                }
                else{
                    TreeSet<Integer> set=map.get(parent);
                    if(set.isEmpty()){
                        ans.add(-1);
                    }
                    else{
                        ans.add(set.first());
                    }
                }
            }
            else{
                online[x]=false;
                map.get(parent).remove(x);
            }
        }

        int size=ans.size();
        int finalAns[]=new int[size];
        for(int i=0;i<size;i++)finalAns[i]=ans.get(i);

        return finalAns;

    }
}