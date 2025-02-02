import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -.
// For each integer, you should choose one from + and - as its new symbol.
// Find out how many ways to assign symbols so that we get sum of integers equal to target S.
public class DP7_targetSum {
    static int findTargetSumWays(int[] a ,int n, int target) {
        int sum = 0;
        for(int e : a) {
            sum += e;
        }
        if((target + sum) % 2 != 0 || target > sum || target + sum < 0)  return 0;
        int req = (target + sum) / 2;
        return solve(a, n, req);
    }
    static int solve(int[] a ,int n, int target) {
        int[][] dp = new int[n+1][target+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=target; j++) {
                if(j == 0) {
                    dp[i][j] = 1;
                } else if(i == 0) {
                    dp[i][j] = 0;
                } else if(a[i-1] <= j) {
                    dp[i][j] = dp[i-1][j - a[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] inp = in.readLine().trim().split(" ");
        int[] ar = new int[n];
        for(int i=0; i<n; i++) {
            ar[i] = Integer.parseInt(inp[i]);
        }
        int target = Integer.parseInt(in.readLine());
        int req = findTargetSumWays(ar, n, target);
        System.out.println(req);
    }
}