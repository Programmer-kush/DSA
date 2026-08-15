class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;

        for (int i = 0; i <= heights.length; i++) {
            int cur = (i == heights.length) ? 0 : heights[i];

            while (!st.isEmpty() && heights[st.peek()] > cur) {
                int h = heights[st.pop()];
                int left = st.isEmpty() ? -1 : st.peek();
                int width = i - left - 1;
                ans = Math.max(ans, h * width);
            }

            st.push(i);
        }

        return ans;
    }
}