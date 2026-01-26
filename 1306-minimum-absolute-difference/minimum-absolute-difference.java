class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans =new ArrayList<>();
        Arrays.sort(arr);
        int min=(int)1e9;
        for(int i=1;i<arr.length;i++){
            min=Math.min(min,Math.abs(arr[i]-arr[i-1]));
        }
        for(int i=0;i<arr.length-1;i++){
            int diff=Math.abs(arr[i+1]-arr[i]);
            if(diff==min){
                List<Integer> ds=new ArrayList<>();
                ds.add(arr[i]);
                ds.add(arr[i+1]);
                ans.add(ds);
            }
        }

        return ans;

    }
}