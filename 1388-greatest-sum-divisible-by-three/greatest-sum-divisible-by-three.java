class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int one = (int)1e9;
        int two = (int)1e9;
        int one2 = (int)1e9;
        int two2 = (int)1e9;

        for (int x : nums) {
            sum += x;
            int m = x % 3;

            if (m == 1) {
                if (x < one) {
                    one2 = one;
                    one = x;
                } else if (x < one2) {
                    one2 = x;
                }
            } else if (m == 2) {
                if (x < two) {
                    two2 = two;
                    two = x;
                } else if (x < two2) {
                    two2 = x;
                }
            }
        }

        int mod = sum % 3;
        if (mod == 0) return sum;

        if (mod == 1) {
            int remove1 = one;
            int remove2 = (two == 1e9 || two2 == 1e9) ? (int)1e9 : two + two2;
            return sum - Math.min(remove1, remove2);
        } else {
            int remove1 = two;
            int remove2 = (one == 1e9 || one2 == 1e9) ? (int)1e9 : one + one2;
            return sum - Math.min(remove1, remove2);
        }
    }
}
