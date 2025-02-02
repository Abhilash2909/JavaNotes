import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Count the number of subset with a given difference
public class DP6_countNoOfSubsetsWithGivenDiff {
    static int countOfSubsetSum(int[] ar, int n, int diff) {
        int sum = 0;
        for(int e : ar) sum += e;
        if((sum + diff) % 2 != 0) return 0;
        int req = (sum + diff) / 2;
        int[][] dp = new int[n+1][req+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=req; j++) {
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
        return dp[n][req];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] inp = in.readLine().trim().split(" ");
        int[] ar = new int[n];
        for(int i=0; i<n; i++) {
            ar[i] = Integer.parseInt(inp[i]);
        }
        int diff = Integer.parseInt(in.readLine());
        int req = countOfSubsetSum(ar, n, diff);
        System.out.println(req);
    }
}