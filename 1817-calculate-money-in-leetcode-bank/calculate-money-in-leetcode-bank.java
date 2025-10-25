class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;
        
        // Sum for complete weeks: each week is an AP starting at (1+weekNumber)
        // Week0: 1+2+...+7 = 28
        // Week1: 2+3+...+8 = 35  => +7 than previous
        // So: 28 + 35 + 42 + ...
        int sum = 0;
        for(int w = 0; w < weeks; w++){
            sum += 28 + (7 * w);
        }
        
        // Partial week
        int start = weeks + 1;
        for(int d = 0; d < days; d++){
            sum += start + d;
        }
        
        return sum;
    }
}
