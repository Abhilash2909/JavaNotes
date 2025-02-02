import java.util.*;

public class revStack {
    public static void reverseStack(Stack<Integer> st) {
        if(st.isEmpty()) {
            return;
        }
        int ele = st.pop();
        reverseStack(st);
        insert(st, ele);
    }

    public static void insert(Stack<Integer> st, int ele) {
        if(st.isEmpty()) {
            st.push(ele);
            return;
        }
        int e = st.pop();
        insert(st, ele);
        st.push(e);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            st.push(sc.nextInt());
        }
        reverseStack(st);
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }
}