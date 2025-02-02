import java.util.*;

// Coin Change Problem Minimum number of coins

public class DP11_coinChangeMinimum {

//    static int[][] dp;
//    public static int minCoins(int coins[], int n, int sum)
//    {
//        dp = new int[n+1][sum+1];
//        for(int[] f : dp) {
//            Arrays.fill(f, -1);
//        }
//        int ans = solve(coins, n, sum, 0);
//        if(ans == Integer.MAX_VALUE) {
//            return -1;
//        }
//        return ans;
//    }
//
//    public int solve(int coins[], int n, int sum, int curr) {
//        if(curr == sum) {
//            return 0;
//        }
//        if(n == 0 || curr > sum) {
//            return Integer.MAX_VALUE;
//        }
//        if(dp[n][curr] != -1) {
//            return dp[n][curr];
//        }
//        int a = solve(coins, n, sum, curr + coins[n-1]);
//        if(a != Integer.MAX_VALUE) {
//            a += 1;
//        }
//        int b = solve(coins, n-1, sum, curr);
//        return dp[n][curr] = Math.min(a, b);
//    }

    public static int minCoins(int[] coins, int n, int sum) {
        int[][] dp = new int[n+1][sum+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=sum; j++) {
                if(j == 0) {
                    dp[i][j] = 0;
                } else if(i == 0) {
                    dp[i][j] = Integer.MAX_VALUE - 1;
                } else if(i == 1) {
                    if(j % coins[i-1] != 0) {
                        dp[i][j] = Integer.MAX_VALUE - 1;
                    } else {
                        dp[i][j] = j / coins[i-1];
                    }
                } else if(coins[i-1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j-coins[i-1]], dp[i-1][j]); // Here +1 is used as we have used Integer.MAX_VALUE-1 previously
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum] == Integer.MAX_VALUE - 1 ? -1 : dp[n][sum];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int m = sc.nextInt();
        int[] coins = new int[m];
        for (int i = 0; i < m; i++) coins[i] = sc.nextInt();
        System.out.println(minCoins(coins, m, v));
    }
}
