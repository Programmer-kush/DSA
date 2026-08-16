class Solution {
    public boolean stoneGameIX(int[] stones) {
        int a = 0, b = 0, c = 0;

        for (int x : stones) {
            if (x % 3 == 0) c++;
            else if (x % 3 == 1) a++;
            else b++;
        }

        if (c % 2 == 0) {
            return a > 0 && b > 0;
        }

        return Math.abs(a - b) > 2;
    }
}