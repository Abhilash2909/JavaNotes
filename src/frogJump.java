public class frogJump {
//    gives the min poss cost to reach the end of the array from the start
//    T.C --> O(2^n), S.C --> O(n)
    static int best(int[] h, int n, int idx){
//        if frog reaches the last stone then poss cost is 0
        if(idx == n-1) {
            return 0;
        }
//      recursively getting the min cost by jumping 1 step to the end of the array
        int op1 = Math.abs(h[idx] - h[idx+1]) + best(h, n, idx+1);
//        if frog reached n-2 stone then cant step to the nth stone, so return op1
        if(idx == n-2) {
            return op1;
        }
//      recursively getting the min cost by jumping 2 steps to the end of the array
        int op2 = Math.abs(h[idx] - h[idx+2]) + best(h, n, idx+2);
        return Math.min(op1, op2);
    }
    public static void main(String[] args) {
        int[] h = {10, 30, 10, 40, 20};
        System.out.println(best(h, h.length, 0));
    }
}