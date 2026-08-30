// class Solution {
//     public int solve(int k,int n,int dp[][]){
//         if(n==1 || n==0) return n;
//         if(k==1) return n;

//         if(dp[k][n] != -1) return dp[k][n];
//         int res=(int)1e9;

//         for(int i=1;i<=n;i++){
//             int broke=solve(k-1,i-1,dp);
//             int not_broke=solve(k,n-i,dp);
//             int curr= 1 + Math.max(broke,not_broke);

//             res=Math.min(curr,res);
//         }
//         return dp[k][n]=res;
//     }
//     public int superEggDrop(int k, int n) {
//         int dp[][]=new int[k+1][n+1];
//         for(int i=0;i<=n;i++){
//             dp[1][i]=i;
//         }
//         for(int i=0;i<=k;i++){
//             dp[i][1]=1;
//         }
      
//         // for(int arr[] : dp){
//         //     Arrays.fill(arr,-1);
//         // }

//         for(int r=2;r<=k;r++){
//             for(int c=2;c<=n;c++){
//                  int res=(int)1e9;

//                 for(int i=1;i<=c;i++){
//                     int broke=dp[r-1][i-1];
//                     int not_broke=dp[r][c-i];
//                     int curr= 1 + Math.max(broke,not_broke);

//                     res=Math.min(curr,res);
//                 }
//                 dp[r][c]=res;
//             }
//         }
//         return dp[k][n];
//     }
// }

class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];

        // Base cases
        for (int r = 1; r <= k; r++) {
            dp[r][0] = 0;
            dp[r][1] = 1;
        }
        for (int c = 1; c <= n; c++) {
            dp[1][c] = c;
        }

        // Tabulation with Binary Search
        for (int r = 2; r <= k; r++) {
            for (int c = 2; c <= n; c++) {
                int low = 1, high = c;
                int res = c; // Upper bound is checking all floors sequentially

                while (low <= high) {
                    int mid = low + (high - low) / 2;

                    int broke = dp[r - 1][mid - 1];
                    int notBroke = dp[r][c - mid];

                    int curr = 1 + Math.max(broke, notBroke);
                    res = Math.min(res, curr);

                    if (broke < notBroke) {
                        // Not broke is larger, need to drop from a higher floor
                        low = mid + 1;
                    } else {
                        // Broke is larger or equal, check lower floors
                        high = mid - 1;
                    }
                }

                dp[r][c] = res;
            }
        }

        return dp[k][n];
    }
}