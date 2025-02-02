// 1. Longest common subsequence (LCS)
//  - 2. Longest common substring
//  - 3. Print LCS
//  - 4. Shortest common subsequence
//  - 5. Shortest Common Supersequence
//  - 6. Min no. of insertions & deletions to convert str1 to str2
//  - 7. Longest repeating subsequence
//  - 8. Length of longest subsequence of str1 which is a substring in str2
//  - 9. Subsequence pattern matching
//  - 10. Count how many times str1 appear as subsequence in str2
//  - Palindrome questions
//    - 11. Longest palindromic subsequence
//    - 12. Longest palindromic substring
//    - 13. Count of palindromic substring
//    - 14. Min deletions in a string to make it a palindrome
//    - 15. Min insertions in a string to make it a palindrome

import java.util.Arrays;
import java.util.Scanner;

// Given 2 strings, return the length of longest common subsequence
public class DP12_longestCommonSubsequence {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s1 = sc.next();
        int m = sc.nextInt();
        String s2 = sc.next();
        // recursive
        System.out.println(solve(s1, s2, n, m));
        // memoization
        dp = new int[n + 1][m + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        System.out.println(memo(s1, s2, n, m));
        // DP
        System.out.println(dp(s1, s2, n, m));

    }

    // "abdefg"
    // "abhfgjg"

    // recursive approach
    public static int solve(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + solve(s1, s2, n - 1, m - 1);
        }
        return Math.max(solve(s1, s2, n - 1, m), solve(s1, s2, n, m - 1));
    }

    // memoization
    public static int memo(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) {
            return dp[n][m] = 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return dp[n][m] = 1 + memo(s1, s2, n - 1, m - 1);
        }
        return dp[n][m] = Math.max(memo(s1, s2, n, m - 1), memo(s1, s2, n - 1, m));
    }

    // dp
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