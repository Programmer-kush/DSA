class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int[] flat = new int[m * n];
        
        // flatten
        int idx = 0;
        for (int[] row : grid)
            for (int val : row)
                flat[idx++] = val;
        
        // check feasibility — all must have same remainder mod x
        int rem = flat[0] % x;
        for (int val : flat)
            if (val % x != rem) return -1;
        
        // sort and pick median
        Arrays.sort(flat);
        int median = flat[flat.length / 2];
        
        // count total operations
        int ops = 0;
        for (int val : flat)
            ops += Math.abs(val - median) / x;
        
        return ops;
    }
}