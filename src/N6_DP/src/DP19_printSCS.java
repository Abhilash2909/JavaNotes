import java.util.Scanner;

public class DP19_printSCS {
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
                    sb.append(s2.charAt(j-1));
                    j--;
                } else {
                    sb.append(s1.charAt(i-1));
                    i--;
                }
            }
        }
        while(i > 0) {
            sb.append(s1.charAt(i-1));
        }
        while(j > 0) {
            sb.append(s2.charAt(j-1));
        }
        System.out.println(sb.reverse());
    }

    // "acbcf"
    // "abcdaf"
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
