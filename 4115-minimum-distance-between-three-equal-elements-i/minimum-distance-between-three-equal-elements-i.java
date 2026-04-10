import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        // Map to store a list of indices for each number
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                map.put(num, new ArrayList<>());
            }
            
            ArrayList<Integer> indices = map.get(num);
            indices.add(i);

            // If we have at least 3 indices, calculate the distance
            // using the formula: 2 * (current_index - index_two_steps_ago)
            if (indices.size() >= 3) {
                int firstIdx = indices.get(indices.size() - 3);
                int currentDistance = 2 * (i - firstIdx);
                minDistance = Math.min(minDistance, currentDistance);
                found = true;
            }
        }

        return found ? minDistance : -1;
    }
}