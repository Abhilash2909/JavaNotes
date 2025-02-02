// In Unbounded Knapsack, we can include an item more than once.

// Variations of Unbounded Knapsack problem
// 1. Rod cutting
// 2. Coinchange I(Max ways)
// 3. Coinchange II(Min coins needed)
// 4. Maximum ribbon cut

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP8_unboundedKnapsack {
    static int[][] dp;
    static void solve(int[] val, int[] wt, int n, int w) {
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=w; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if(wt[i-1] <= j) {
                    // just change dp[i-1] --> dp[i] as we are including an item more than once
                    dp[i][j] = Math.max(val[i-1] + dp[i][j - wt[i-1]],  dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = in.readLine().trim().split("\\s+");
        int n = Integer.parseInt(line1[0]);
        int w = Integer.parseInt(line1[1]);

        String[] line2 = in.readLine().trim().split("\\s+");
        int[] val = new int[n];
        for(int i = 0;i < n;i++)
            val[i] = Integer.parseInt(line2[i]);

        String[] line3 = in.readLine().trim().split("\\s+");
        int[] wt = new int[n];
        for(int i = 0;i < n;i++)
            wt[i] = Integer.parseInt(line3[i]);

        dp = new int[n+1][w+1];
        solve(val, wt, n, w);
        System.out.println(dp[n][w]);
    }
}
