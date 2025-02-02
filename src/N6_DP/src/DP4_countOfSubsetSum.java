package N6_DP.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Count of Subsets Sum with a Given Sum
public class DP4_countOfSubsetSum {
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String input[] = in.readLine().trim().split("\\s+");
        int ar[] = new int[n];
        for(int i = 0;i < n;i++)
            ar[i] = Integer.parseInt(input[i]);
        int sum = Integer.parseInt(in.readLine());
        int x = countOfSubsetSum(ar, n, sum);
        System.out.println(x);
    }
    static int countOfSubsetSum(int ar[], int n, int sum) {
        int[][] dp = new int[n+1][sum+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=sum; j++) {
                if(j == 0) {
                    dp[i][j] = 1;
                } else if(i == 0) {
                    dp[i][j] = 0;
                } else if(ar[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-ar[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
