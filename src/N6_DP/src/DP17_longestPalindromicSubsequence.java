import java.util.Scanner;

// Given a str find the len of longest palidromic subsequence
public class DP17_longestPalindromicSubsequence {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s1 = sc.next();
        String s2 = new StringBuilder().reverse().toString(); // reverse of a given string

        int lpsLen = dp(s1, s2, n, n); // Length of longest Palindromic Subsequence
        System.out.println(lpsLen);
    }

    public static int dp(String s1, String s2, int n, int m) {
        dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=m; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
