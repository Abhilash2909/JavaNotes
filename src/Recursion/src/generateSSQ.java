import java.util.ArrayList;

public class generateSSQ {

//    below approach is recursive and uses 2^n storage space and time complexity is O(2^n)
//    so to avoid 2^n storage space we directly print the subsequences of the string in the printSSQ method
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