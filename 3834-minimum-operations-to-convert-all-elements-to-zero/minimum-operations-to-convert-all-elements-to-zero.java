import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int minOperations(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;

        for (int n : nums) {
            
            while (!stack.isEmpty() && stack.peek() > n) {
                stack.pop();
            }

            if (n > 0 && (stack.isEmpty() || n != stack.peek())) {
                res++;
                stack.push(n);
            }
        }

        return res;
    }
}