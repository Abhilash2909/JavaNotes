import java.util.*;

public class sortAStack {
    public static void insert(Stack<Integer> st, int temp) {
        if(st.isEmpty() || st.peek() <= temp) {
            st.push(temp);
            return;
        }
        int val = st.pop();
        insert(st, temp);
        st.push(val);
    }
    public static void sortStack(Stack<Integer> st) {
        if(st.size() == 1) {
            return;
        }
        int temp = st.pop();
        sortStack(st);
        insert(st, temp);
    }
    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s = new Stack<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            s.push(sc.nextInt());
        }

        sortStack(s);
        while (!s.isEmpty()) {
            System.out.print(s.peek() + " ");
            s.pop();
        }
    }
}