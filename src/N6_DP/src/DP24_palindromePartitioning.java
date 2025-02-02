import java.util.Arrays;
import java.util.Scanner;

public class DP24_palindromePartitioning {
    public static void main(String[] args) { //
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        dp = new int[1001][1001];
        for(int[] i : dp) {
            Arrays.fill(i, -1);
        }
//        int res = recursive(s, 0, n-1);
//        int res = memo(s, 0, n-1);
        int res = optimizedMemo(s, 0, n-1);
        System.out.println(res);

    }

    // recursive
    public static int recursive(String s, int i, int j) {
        if(i >= j) {
            return 0;
        }
        if(isPalindrome(s, i, j)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++) {
            int temp = 1 + recursive(s, i, k) + recursive(s, k+1, j);
            if(temp < min) {
                min = temp;
            }
        }
        return min;
    }

    public static boolean isPalindrome(String s, int i, int j) {
        if(i == j) {
            return true;
        }
        if(i > j) {
            return true;
        }
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //memoization
    static int dp[][];
    public static int memo(String s, int i, int j) {
        if(i >= j) {
            return 0;
        }
        if(isPalindrome(s, i, j)) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++) {
            int temp = 1 + memo(s, i, k) + memo(s, k+1, j);
            if(temp < min) {
                min = temp;
            }
        }
        return dp[i][j] = min;
    }

    //optimized memoization
    public static int optimizedMemo(String s, int i, int j) {
        if(i >= j) {
            return 0;
        }
        if(isPalindrome(s, i, j)) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        int left = 0, right = 0;
        for(int k=i; k<j; k++) {
            if(dp[i][k] != -1) {
                left = dp[i][k];
            } else {
                left = memo(s, i, k);
                dp[i][k] = left;
            }
            if(dp[k+1][j] != -1) {
                 right = dp[k+1][j];
            } else {
                right = memo(s, k+1, j);
                dp[k+1][j] = right;
            }
            int temp = 1 + left + right;
            if(temp < min) {
                min = temp;
            }
        }
        return dp[i][j] = min;
    }
}
