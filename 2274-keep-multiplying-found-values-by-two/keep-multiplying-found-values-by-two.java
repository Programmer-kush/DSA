class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set = new HashSet<>();
        for(int x: nums) set.add(x);
        while(set.contains(original)) original <<= 1;
        return original;
    }
}
