import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class combinationSum {
    public static void main(String[] args) throws IOException {

            // Approach:-

            // Sort the array(non-decreasing).
            // First remove all the duplicates from array.
            // Then use recursion and backtracking to solve the problem.
            // If:
            //     at any time subproblem sum==0 then add that array to the result(vector of vectors).
            // else if:
            //     sum is negative then ignore that subproblem.
            // else:
            //     insert the present array in that index to the current vector and call the function with sum=sum-A[index] and index=index,
            //     then pop that element from current index (backtrack) and call the function with sum=sum and index=index+1,

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(System.out);
            int t = Integer.parseInt(br.readLine());
            while(t-- >0)
            {
                String str[] = br.readLine().trim().split(" ");
                int n = Integer.parseInt(str[0]);
                ArrayList<Integer> list = new ArrayList<>();
                str = br.readLine().trim().split(" ");
                for(int i = 0; i <n;i++)
                    list.add(Integer.parseInt(str[i]));
                str = br.readLine().trim().split(" ");
                int sum = Integer.parseInt(str[0]);
                Solution ob = new Solution();
                ArrayList<ArrayList<Integer>> res = combinationSum(list, sum);
                if (res.isEmpty()) {
                    out.print("Empty");
                }
                // Print all combinations stored in res.
                for (int i = 0; i < res.size(); i++) {
                    if (!res.isEmpty()) {
                        out.print("(");
                        List<Integer> ij = res.get(i);
                        for (int j = 0; j < ij.size (); j++) {
                            out.print(ij.get(j));
                            if(j < ij.size()-1)
                                out.print(" ");
                        }
                        out.print(")");
                    }
                }
                out.println();
                res.clear();
            }
            out.flush();
    }

    static void solve(ArrayList<Integer> a, int b, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ans, int sum, int idx) {
        if(sum > b) return;

        if(b == sum) {
            ans.add(curr);
        }

        for(int i=idx; i<a.size(); i++) {
            curr.add(a.get(i));
            sum += a.get(i);
            solve(a, b, new ArrayList<>(curr), ans, sum, i);
            sum -= a.get(i);
            curr.remove(curr.size() - 1);
        }
    }

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b)
    {
        Collections.sort(a);
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(a.get(0));
        for(int i=1; i<a.size(); i++){
            if(a.get(i) == a.get(i-1)) continue;
            else    ar.add(a.get(i));
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        solve(ar, b, new ArrayList<>(), ans, 0, 0);
        return ans;
    }
}
