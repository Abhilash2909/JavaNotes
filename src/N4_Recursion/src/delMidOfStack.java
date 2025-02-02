import java.util.Scanner;
import java.util.Stack;

public class delMidOfStack {
    public static void delMid(Stack<Integer> st, int k) {
        if(k == 1) {
            st.pop();
            return;
        }
        int ele = st.pop();
        delMid(st, k-1);
        st.push(ele);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++) {
            st.push(sc.nextInt());
        }
        int len = n / 2 + 1;
        delMid(st, len);
        while((!st.isEmpty())) {
            System.out.print(st.pop() + " ");
        }
    }
}