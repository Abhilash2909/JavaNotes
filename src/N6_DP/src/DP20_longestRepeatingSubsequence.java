import java.util.Arrays;
import java.util.Scanner;

// Given a str find the len of longest repeating subsequence
public class DP20_longestRepeatingSubsequence {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s1 = sc.next();
        System.out.println(dp(s1, s1, n, n));
    }

    public static int dp(String s1, String s2, int n, int m) {
        dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=m; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if(s1.charAt(i - 1) == s2.charAt(j - 1) && i != j) { // just add a condition(i != j) to the lcs code and... voila!
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}