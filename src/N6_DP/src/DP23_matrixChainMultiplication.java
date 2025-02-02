import java.util.Scanner;

// Matrix chain Multiplication(Recursive, Memo)
// Printting MCX
// Evaluate exp to true / Boolean parenthesis
// Min/Max value of an exp
// Palindrome partitioning
// Scramble string
// Egg droping problem

public class DP23_matrixChainMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for(int i=0; i<n; i++) {
            ar[i] = sc.nextInt();
        }
        int res = recursive(ar, 1, n-1);
        System.out.println(res);
    }

    // recursive
    public static int recursive(int[] ar, int i, int j) {
        if(i >= j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++) {
            int temp = recursive(ar, i, k) + recursive(ar, k+1, j) + ar[i-1] * ar[k] * ar[j];
            if(temp < min) {
                min = temp;
            }
        }
        return min;
    }

    //memoization
    static int dp[][];
    public static int memo(int[] ar, int i, int j) {
        dp = new int[1001][1001];
        if(i >= j) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++) {
            int temp = memo(ar, i, k) + memo(ar, k+1, j) + ar[i-1] * ar[k] * ar[j];
            if(temp < min) {
                min = temp;
            }
        }
        return dp[i][j] = min;
    }
}
