class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int count = n * 2;

        Arrays.sort(reservedSeats, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        boolean[] flags = new boolean[3];
        Arrays.fill(flags, true);

        for (int i = 0; i < reservedSeats.length; i++) {

            if (i > 0 && reservedSeats[i][0] != reservedSeats[i - 1][0]) {
                if (flags[0] && flags[2]) count -= 0;
                else if (flags[0] || flags[1] || flags[2]) count -= 1;
                else count -= 2;

                Arrays.fill(flags, true);
            }

            int col = reservedSeats[i][1];

            if (col >= 2 && col <= 5) flags[0] = false;
            if (col >= 4 && col <= 7) flags[1] = false;
            if (col >= 6 && col <= 9) flags[2] = false;
        }

        if (reservedSeats.length > 0) {
            if (flags[0] && flags[2]) count -= 0;
            else if (flags[0] || flags[1] || flags[2]) count -= 1;
            else count -= 2;
        }

        return count;
    }
}