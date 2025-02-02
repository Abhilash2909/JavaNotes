import java.util.*;

public class sortAnArray {
    public static void insert(ArrayList<Integer> ar, int temp) {
        if(ar.isEmpty() || ar.get(ar.size() - 1) <= temp) {
            ar.add(temp);
            return;
        }
        int val = ar.remove(ar.size() - 1);
        insert(ar, temp);
        ar.add(val);
    }

    public static void sort(ArrayList<Integer> ar) {
        if(ar.size() == 1) {
            return;
        }
        int temp = ar.remove(ar.size() - 1);
        sort(ar);
        insert(ar, temp);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> ar = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ar.add(scanner.nextInt());
        }
        sort(ar);
        for (int i = 0; i < n; i++) {
            System.out.print(ar.get(i) + " ");
        }
    }
}
/*

    void sort(v) {
        if(v.size() == 1) return;
        int te = mpv.pop_back();
        sort(v);
        insert(v, temp);
    }
    void insert(vector<int> v, int t) {
        if(v.size() == 0 || v[v.size()-1] <= t) {
            v.push_back(t);
        }
        int val = v[v.size()-1];
        v.pop_back();
        insert(v, t);
        v.push_back(val);
    }
 */