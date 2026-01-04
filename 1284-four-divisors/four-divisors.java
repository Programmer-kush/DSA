class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += getFourDivisorsSum(num);
        }
        return totalSum;
    }

    private int getFourDivisorsSum(int num) {
        int count = 0;
        int sum = 0;

        // Iterate only up to the square root of num
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                // If i is a divisor, add it
                count++;
                sum += i;

                // Check if the partner divisor (num / i) is different
                if (i * i != num) {
                    count++;
                    sum += (num / i);
                }
            }
            
            // Optimization: If we exceed 4 divisors, stop early
            if (count > 4) return 0;
        }

        // Only return the sum if there are exactly four divisors
        return (count == 4) ? sum : 0;
    }
}