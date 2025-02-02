package N6_DP.src;

import java.io.*;

public class DP3_partitionEqualSubsetSum {
    public static void main(String[] args)throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] input_line = in.readLine().trim().split("\\s+");
        int[] ar = new int[n];
        for(int i = 0;i < n;i++)
            ar[i] = Integer.parseInt(input_line[i]);

        int x = equalPartition(n, ar);
        if(x == 1)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
    static boolean subsetSum(int[] ar, int n, int sum) {
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=sum; j++) {
                if(j == 0) {
                    dp[i][j] = true;
                } else if(i == 0) {
                    dp[i][j] = false;
                } else if(ar[i-1] <= j) {
                        dp[i][j] = dp[i-1][j-ar[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    static int equalPartition(int n, int[] ar) {
        int sum = 0;
        for(int e : ar) {
            sum += e;
        }
        if((sum % 2) != 0) {
            return 0;
        }
        return subsetSum(ar, n, sum / 2)? 1 : 0;
    }
}