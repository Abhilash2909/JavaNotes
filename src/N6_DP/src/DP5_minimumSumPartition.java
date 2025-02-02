import java.util.*;

// Minimum Subset Sum Difference
// Minimize the diff of 2 subsets. So lets say s1, s2 are subsets ->  Minimize (s2 - s1)  ->  (range - s1 - s1)  ->  (range - 2*s1)
// So minimize the (range - 2*s1). Here range is ntg but the total sum:)

public class DP5_minimumSumPartition {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0;i<n;i++)
            a[i] = sc.nextInt();
        System.out.println(minDifference(a,n));
    }

    static boolean[][] dp;
    public static int minDifference(int[] ar, int n) {
        int sum = 0;
        for(int i : ar) sum += i;
        dp = new boolean[n+1][sum+1];
        subsetSum(ar, n, sum);
        int min = Integer.MAX_VALUE;
        for(int i=0; i<=sum/2; i++) {
            if(dp[n][i]) {
                min = Math.min(min, sum - 2 * i);
            }
        }
        return min;
    }

    static void subsetSum(int[] ar, int n, int sum) {
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
    }
}