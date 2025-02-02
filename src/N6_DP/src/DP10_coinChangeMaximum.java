import java.util.*;

// Coin Change Problem Maximum Number of ways
public class DP10_coinChangeMaximum {
    public static long count(int coins[], int n, int sum) {
        long[][] dp = new long[n+1][sum+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=sum; j++) {
                if(j == 0) {
                    dp[i][j] = 1;
                } else if(i == 0) {
                    dp[i][j] = 0;
                } else if(coins[i-1] <= j) {
                    dp[i][j] =  dp[i][j-coins[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int n = sc.nextInt();
        int coins[] = new int[n];
        for (int i = 0; i < n; i++) coins[i] = sc.nextInt();
        System.out.println(count(coins, n, sum));
    }
}
