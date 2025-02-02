import java.io.*;

// Rod cutting problem
// Get the max value obtainable by cutting up the rod and selling the pieces.
public class DP9_rodCutting {
    public static int cutRod(int[] price, int n) {
        int[][] dp = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {   // Iterate through lengths of the rod
            for(int j=1; j<=n; j++) {  // Iterate through each possible length to cut
                if(i <= j) {
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-i], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][n];
    }

    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine().trim());
        String[] s =in.readLine().trim().split(" ");
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) ar[i] = Integer.parseInt(s[i]);

        out.println(cutRod(ar, n));
        out.flush(); // Ensures output is printed before the program ends
    }
}
