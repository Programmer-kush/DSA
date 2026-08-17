class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int n = nums.length;
        int ans[] = new int[n - k + 1];
        int ind = 0;

        for (int i = 0; i < n; i++) {

            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.removeLast();
            }

            q.addLast(i);

            if (i >= k - 1) {
                while (q.peekFirst() < i - k + 1) {
                    q.removeFirst();
                }

                ans[ind++] = nums[q.peekFirst()];
            }
        }

        return ans;
    }
}