// class Solution {
//     public void solve(int index, int[] nums, List<Integer> ds, Set<List<Integer>> ans) {
//         if (index == nums.length) {
//             ans.add(new ArrayList<>(ds));
//             return;
//         }

//         ds.add(nums[index]);
//         solve(index + 1, nums, ds, ans);

//         ds.remove(ds.size() - 1);
//         solve(index + 1, nums, ds, ans);
//     }

//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//         Arrays.sort(nums);

//         Set<List<Integer>> ans = new HashSet<>();
//         solve(0, nums, new ArrayList<>(), ans);

//         return new ArrayList<>(ans);
//     }
// }

class Solution {
    public void solve(int index, int[] nums, List<Integer> ds, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(ds));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;

            ds.add(nums[i]);
            solve(i + 1, nums, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), ans);

        return ans;
    }
}