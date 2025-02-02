import java.io.*;
import java.util.*;

// 0-1 Knapsack Problem

// Variations of 0-1 knapsack problem
// 1. Subset Sum Problem
// 2. Equal Sum Partition Problem
// 3. Count of Subsets Sum with a Given Sum
// 4. Minimum Subset Sum Difference
// 5. Count the number of subset with a given difference
// 6. Target sum

public class DP1_knapsack {
    // Function to return max value that can be put in knapsack of capacity W.
    static int[][] dp;
    static int knapSack(int w, int[] wt, int[] val) {
        dp = new int[wt.length+1][w+1];
        for(int[] i : dp)  Arrays.fill(i, -1);
        knapSack(w, wt.length, wt, val);
        return dp[wt.length][w];
    }

    static int knapSack(int w, int n, int[] wt, int[] val) {
        if(n == 0 || w == 0) {
            return 0;
        }
        if(dp[n][w] != -1) {
            return dp[n][w];
        }
        if(wt[n-1] <= w) {
            return dp[n][w] = Math.max(val[n-1] + knapSack(w - wt[n-1], n-1, wt, val), knapSack(w, n-1, wt, val));
        }
        return dp[n][w] = knapSack(w, n-1, wt, val);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int w = Integer.parseInt(br.readLine());

        String[] tokens = br.readLine().trim().split(" ");
        List<Integer> arr = new ArrayList<>();

        // Parse the tokens into integers and add to the array
        for (String token : tokens) {
            arr.add(Integer.parseInt(token));
        }

        int[] val = new int[arr.size()];
        int idx = 0;
        for (int i : arr) val[idx++] = i;

        String[] in = br.readLine().split(" ");
        List<Integer> arr1 = new ArrayList<>();

        // Parse the tokens into integers and add to the array
        for (String i : in) {
            arr1.add(Integer.parseInt(i));
        }

        int[] wt = new int[arr1.size()];
        idx = 0;
        for (int i : arr1) wt[idx++] = i;

        System.out.println(knapSack(w, wt, val));
    }
}
