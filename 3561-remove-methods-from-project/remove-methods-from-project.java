class Solution {
    public void dfs(int i,List<List<Integer>> adj,boolean bug[]){
        bug[i]=true;

        for(int v : adj.get(i)){
            if(!bug[v]){
                dfs(v,adj,bug);
            }
        }
        return;
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int edge[] : invocations){
            adj.get(edge[0]).add(edge[1]);
        }

        boolean bug[]=new boolean[n];
        bug[k]=true;

        dfs(k,adj,bug);

        for(int i=0;i<n;i++){
            if(!bug[i]){
                for(int v : adj.get(i)){
                    if(bug[v]){
                        Arrays.fill(bug,false);
                        break;
                    }
                }
            }
        }

        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!bug[i]) ans.add(i);
        }
        return ans;





    }
}