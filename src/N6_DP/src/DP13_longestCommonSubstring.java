import java.util.Arrays;
import java.util.Scanner;

public class DP13_longestCommonSubstring {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s1 = sc.next();
        int m = sc.nextInt();
        String s2 = sc.next();
        int res = 0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                res = Math.max(res, solve(s1, s2, i, j));
            }
        }
//        System.out.println(res);
        System.out.println(dp(s1, s2, n, m));
        System.out.println(dps(s1, s2, n, m));
    }

    // recursive approach
    public static int solve(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0 || s1.charAt(n - 1) != s2.charAt(m - 1)) {
            return 0;
        }
        return 1 + solve(s1, s2, n - 1, m - 1);
    }

    // dp
    public static int dp(String s1, String s2, int n, int m) {
        // abcd
        // cdef
        int[][] dp = new int[n+1][m+1];
        int res = 0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    res = Math.max(res, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return res;
    }

    // Space Optimized DP
    public static int dps(String s1, String s2, int n, int m) {
        // abcd
        // cdef
        int maxlen = Math.max(n, m);
        int[] prev = new int[maxlen+1]; // to store previous row values
        int res = 0;
        for(int i=1; i<=n; i++) {
            int[] curr = new int[maxlen+1];
            for(int j=1; j<=m; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j-1];
                    res = Math.max(res, curr[j]);
                } else {
                    curr[j] = 0;
                }
            }
            prev = curr; // update the prev row with curr row values
        }
        return res;
    }
}
