class Solution {

    public boolean isPossible(int val, int[][] tasks) {
        for (int[] arr : tasks) {
            if (val < arr[1]) return false;
            val -= arr[0];
        }
        return true;
    }

    public int minimumEffort(int[][] tasks) {
        // Sort by (min - actual) DESCENDING: highest buffer tasks done first
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        int low = 0;
        int high = 0;
        for (int[] arr : tasks) {
            high += arr[0];          // sum of all actuals
        }
        high += Arrays.stream(tasks)
                      .mapToInt(a -> a[1])
                      .max().getAsInt(); // + max minimum

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (isPossible(mid, tasks)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}