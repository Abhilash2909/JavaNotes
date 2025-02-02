//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;

import java.util.*;
import java.lang.*;
import java.io.*;

//public class PermutationsOfString {
//    public void solve(Set<String> st, String curr, String s) {
//        if(s.isEmpty()) {
//            st.add(curr);
//            return;
//        }
//
//        char c = s.charAt(0);
//        for(int i=0; i<=curr.length(); i++) {
//            String a = curr.substring(0, i);
//            String b = curr.substring(i);
//            solve(st, a+c+b, s.substring(1));
//        }
//    }
//
//    public List<String> find_permutation(String s) {
//        Set<String> st = new HashSet<>();
//        solve(st, "", s);
//        List<String> ans = new ArrayList<>(st);
//        Collections.sort(ans);
//        return ans;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter out=new PrintWriter(System.out);
//        int t = Integer.parseInt(br.readLine().trim());
//        while(t-->0)
//        {
//            String S = br.readLine().trim();
//            PermutationsOfString obj = new PermutationsOfString();
//            List<String> ans = obj.find_permutation(S);
//            for (String an : ans) {
//                out.print(an + " ");
//            }
//            out.println();
//        }
//        out.close();
//    }
//}



public class PermutationsOfString {
    // Helper method to generate permutations
    private void permute(StringBuilder s, int l, int r, Set<String> ans) {
        // Base case
        if (l == r) {
            ans.add(s.toString());
        } else {
            // Permutations made
            for (int i = l; i <= r; i++) {
                // Swapping done
                swap(s, l, i);
                // Recursion called
                permute(s, l + 1, r, ans);
                // Backtrack
                swap(s, l, i);
            }
        }
    }

    // Method to swap characters in a StringBuilder
    private void swap(StringBuilder s, int i, int j) {
        char temp = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, temp);
    }

    // Method to find permutations of a given string
    public List<String> find_permutation(String S) {
        int n = S.length();
        Set<String> ans = new HashSet<>();
        permute(new StringBuilder(S), 0, n - 1, ans);
        List<String> result = new ArrayList<>(ans);
        Collections.sort(result); // To get a sorted list
        return result;
    }

    public static void main(String[] args) {
        PermutationsOfString obj = new PermutationsOfString();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<String> permutations = obj.find_permutation(s);
        for (String p : permutations) {
            System.out.print(p + " ");
        }
        System.out.println();
    }
}