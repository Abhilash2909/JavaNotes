import java.util.ArrayList;
import java.util.Scanner;

public class recursionMedium {
    public static ArrayList<String> getSubSequences(String s) {
        ArrayList<String> ans = new ArrayList<>();
        if(s.isEmpty()) {
            ans.add("");
            return ans;
        }

        char curr = s.charAt(0);
        ArrayList<String> smallAns = getSubSequences(s.substring(1));
        for(String ss : smallAns) {
            ans.add(ss);
            ans.add(curr+ss);
        }
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<String> ans = getSubSequences("abc");
        for(String ss : ans) {
            System.out.println(ss);
        }
    }
}