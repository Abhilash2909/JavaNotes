public class PrintSSQ {
//    number of max. stack frames at any instances * max. space occupied in 1 stack
//    S.C: O(n*n), T.C: O(
    public static void printSSQ(String s, String currAns) {
        if(s.isEmpty()) {
            System.out.println(currAns);
            return;
        }
        char curr = s.charAt(0);
        String remStr = s.substring(1);
        printSSQ(remStr,  currAns + curr);
        printSSQ(remStr, currAns);

    }
    public static void main(String[] args) {
        printSSQ("abc", "");
    }
}