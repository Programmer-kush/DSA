class Solution {
    public void solve(int num,int sum,int k,int n,List<Integer> ds,List<List<Integer>> ans){
        if(k==0 && sum==n){
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(k <=0) return;
        if((num > 9) || (sum>n)) return;

        //take
        ds.add(num);
        solve(num + 1 ,sum + num ,k-1,n,ds,ans);

        //not_take
        ds.remove(ds.size()-1);
        solve(num + 1,sum , k,n,ds,ans);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> ds=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        solve(1,0,k,n,ds,ans);
        return ans;
    }
}