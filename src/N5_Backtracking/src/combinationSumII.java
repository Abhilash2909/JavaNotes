package N5_Backtracking.src;

import java.io.*;
import java.lang.*;
import java.util.*;
public class combinationSumII {
    public static void solve(int arr[], List<List<Integer>> ans, int idx, int req, List<Integer> curr) {
        if(req == 0) {
            Collections.sort(curr);
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=idx; i<arr.length; i++) {
            if(i > idx && arr[i] == arr[i-1]) continue;
            if(arr[i] > req) break;
            curr.add(arr[i]);
            solve(arr, ans, i+1, req - arr[i], curr);
            curr.remove(curr.size()-1);
        }
    }

    public static List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        solve(arr, ans, 0, k, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
            List<List<Integer>> ans =  CombinationSum2(a, n, k);
            for (List<Integer> list: ans) {
                for (int x: list) ot.print(x + " ");
                ot.println();
            }
            if (ans.isEmpty()) ot.println();
        } ot.close();
    }
}
