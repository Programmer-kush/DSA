class Solution {
    public int maximumProduct(int[] nums) {
        PriorityQueue<Integer> largest = new PriorityQueue<>();
        PriorityQueue<Integer> smallest = new PriorityQueue<>((a, b) -> b - a);

        for (int x : nums) {
            largest.offer(x);
            if (largest.size() > 3) largest.poll();

            smallest.offer(x);
            if (smallest.size() > 2) smallest.poll();
        }

        int[] max = new int[3];
        for (int i = 2; i >= 0; i--) {
            max[i] = largest.poll();
        }

        int min1 = smallest.poll();
        int min2 = smallest.poll();

        int p1 = max[0] * max[1] * max[2];
        int p2 = max[0] * min1 * min2;

        return Math.max(p1, p2);
    }
}