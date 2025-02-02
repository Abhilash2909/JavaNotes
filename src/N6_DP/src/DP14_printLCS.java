import java.util.Scanner;

public class DP14_printLCS {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        String s1 = sc.next();
        int n = sc.nextInt();
        String s2 = sc.next();

        dp(s1, s2, m, n);

        int i=m, j=n;
        StringBuilder sb = new StringBuilder();
        while(i > 0 && j > 0) {
            if(s1.charAt(i-1) == s2.charAt((j-1))) {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else {
                if(dp[i][j-1] > dp[i-1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }
        System.out.println(sb.reverse());
    }

    // "ABCDGH"
    // "AEDFHR"
    public static int dp(String s1, String s2, int m, int n) {
        dp = new int[m+1][n+1];
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}