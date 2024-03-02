public class keyPadCominations {
    static void combinations(String s, String[] km, String res) {
        if(s.isEmpty()) {
            System.out.print(res + " ");
            return;
        }
        int digit = s.charAt(0)-'0';
        String currChoice = km[digit];
        for(int i=0; i<currChoice.length(); i++) {
            combinations(s.substring(1), km, res + currChoice.charAt(i));
        }
    }
    public static void main(String[] args) {
        String digits = "234";
        //              0   1    2      3       4     5      6       7      8       9
        String[] km = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        combinations(digits, km, "");
    }
}