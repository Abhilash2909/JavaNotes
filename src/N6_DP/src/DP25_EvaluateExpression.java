import java.util.*;

// Evaluate Expression To True Boolean Parenthesization

// This code provides a recursive solution for evaluating the Boolean expression.
// It works by splitting the expression into subexpressions at each operator and recursively calculating
// the number of ways each subexpression can evaluate to true or false based on the operator between them.

public class DP25_EvaluateExpression {
    public static int solve(char[] ch, int i, int j, Boolean isTrue) {
        if(i > j) {
            return 0;
        }
        if(i == j) {
            if(isTrue) {
                return ch[i] == 'T' ? 1 : 0;
            } else {
                return ch[i] == 'F' ? 1 : 0;
            }
        }
        int ans = 0;
        for(int k=i+1; k<j; k+=2) {
            int lt = solve(ch, i, k-1, true);
            int lf = solve(ch, i, k-1, false);
            int rt = solve(ch, k+1, j, true);
            int rf = solve(ch, k+1, j, false);

            if(ch[k] == '&') {
                if(isTrue) {
                    ans += lt * rt;
                } else {
                    ans += (lt * rf + lf * rt + lf * rf);
                }
            }

            if(ch[k] == '|') {
                if(isTrue) {
                    ans += (lt * rt + lt * rf + lf * rt);
                } else {
                    ans += lf * rf;
                }
            }

            if(ch[k] == '^') {
                if(isTrue) {
                    ans += (lt * rf + lf * rt);
                } else {
                    ans += (lt * rt + lf * rf);
                }
            }
        }
        return ans;
    }

    static int solve(char[] ch, int i, int j, int isTrue, int[][][] dp){

        if(i > j){
            return 0;
        }

        if(i == j){
            if(isTrue == 1){
                return ch[i] == 'T' ? 1 : 0;
            } else {
                return ch[i] == 'F' ? 1 : 0;
            }
        }

        if(dp[i][j][isTrue] != -1){
            return dp[i][j][isTrue];
        }

        int ans = 0;

        for(int k = i + 1; k < j; k = k + 2){

            int leftTrue = solve(ch, i, k - 1, 1, dp);
            int leftFalse = solve(ch, i, k - 1, 0, dp);
            int rightTrue = solve(ch, k + 1, j, 1, dp);
            int rightFalse = solve(ch, k + 1, j, 0, dp);

            if(ch[k] == '^'){
                if(isTrue == 1){
                    ans = ans + (leftTrue * rightFalse) + (leftFalse * rightTrue);
                } else {
                    ans = ans + (leftTrue * rightTrue) + (leftFalse * rightFalse);
                }
            } else if (ch[k] == '&'){
                if(isTrue == 1){
                    ans = ans + (leftTrue * rightTrue);
                } else {
                    ans = ans + (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftFalse * rightFalse);
                }
            } else if (ch[k] == '|'){
                if(isTrue == 1){
                    ans = ans + (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftTrue * rightTrue);
                } else {
                    ans = ans + (leftFalse * rightFalse);
                }
            }
        }

        return dp[i][j][isTrue] = ans % 1003; // % 1003 is mentioned in problem description in GFG
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();;
        int ways = 0;

        // Recursive
//      ways = solve(s.toCharArray(), 0, n-1, true);

        // Memoized
        int[][][] dp = new int[s.length() + 1][s.length() + 1][2];
        for(int[][] row: dp){
            for(int[] col: row){
                Arrays.fill(col, -1);
            }
        }
        ways = solve(s.toCharArray(), 0, n-1, 1, dp);
        System.out.println(ways);
    }
}
