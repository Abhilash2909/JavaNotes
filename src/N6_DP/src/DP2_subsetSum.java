package N6_DP.src;

import java.io.*;

public class DP2_subsetSum {
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input_line = br.readLine().trim().split("\\s+");
        int[] ar= new int[n];
        for(int i = 0; i < n; i++)
            ar[i] = Integer.parseInt(input_line[i]);
        int sum = Integer.parseInt(br.readLine());
        System.out.println(isSubsetSum(n, ar, sum) ? "YES" : "NO");
    }
    static Boolean isSubsetSum(int n, int[] ar, int sum){

        // Recursive Approach(TLE)

        // if(n == 0 || sum < 0) {
        //     return false;
        // }
        // if(sum == 0) {
        //     return true;
        // }
        // boolean flag = isSubsetSum(n-1, ar, sum - ar[n-1]) || isSubsetSum(n-1, ar, sum);
        // return flag;

        // Top-Down Approach

        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i=0; i<=n; i++) {
            for(int j=0; j<=sum; j++) {
                if(j == 0) {
                    dp[i][j] = true;
                } else if(i == 0) {
                    dp[i][j] = false;
                } else if(ar[i-1] <= j) {
                    dp[i][j] = dp[i - 1][j - ar[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }

    // Memoization(TLE)

    // static boolean memo(int[] ar, boolean[][] dp, int n, int sum) {
    //     if(n == 0 && sum == 0) {
    //         return dp[n][sum] = true;
    //     } else if(sum == 0) {
    //         return dp[n][sum] = true;
    //     } else if(n == 0) {
    //         return dp[n][sum] = false;
    //     }

    //     if(ar[n-1] <= sum) {
    //         dp[n][sum] = memo(ar, dp, n-1, sum - ar[n-1]) || memo(ar, dp, n-1, sum);
    //     } else {
    //         dp[n][sum] = memo(ar, dp, n-1, sum);
    //     }

    //     return dp[n][sum];
    // }
}