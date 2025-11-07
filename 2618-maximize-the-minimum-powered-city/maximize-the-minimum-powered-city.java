class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] power = new long[n];
        
        // Precompute initial window-sum power using prefix windowing
        long window = 0;
        for (int i = 0; i <= r && i < n; i++) {
            window += stations[i];
        }
        power[0] = window;
        for (int i = 1; i < n; i++) {
            if (i - r - 1 >= 0) window -= stations[i - r - 1];
            if (i + r < n) window += stations[i + r];
            power[i] = window;
        }

        long low = 0, high = (long)1e18, ans = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            if (can(power, r, k, mid, n)) {
                ans = mid;
                low = mid + 1;   // try for a higher minimum
            } else {
                high = mid - 1;  // too ambitious, dial down
            }
        }

        return ans;
    }

    // Check if we can make all cities have at least `target` power
    private boolean can(long[] power, int r, long k, long target, int n) {
        long[] diff = new long[n];
        long added = 0, need = 0;

        for (int i = 0; i < n; i++) {
            added += diff[i]; // current cumulative addition

            long current = power[i] + added;
            if (current < target) {
                need = target - current;
                if (need > k) return false;  // not enough stations to place

                k -= need;
                added += need;

                int pos = Math.min(n - 1, i + r); 
                if (pos + r + 1 < n) diff[pos + r + 1] -= need;
            }
        }
        return true;
    }
}
