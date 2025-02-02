import java.io.*;
import java.lang.*;
import java.util.Arrays;
import java.util.Comparator;

public class fractionalKnapsack {
    int value, weight;

    fractionalKnapsack(int x, int y) {
        this.value = x;
        this.weight = y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            fractionalKnapsack[] arr = new fractionalKnapsack[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0, k = 0; i < n; i++) {
                arr[i] = new fractionalKnapsack(Integer.parseInt(inputLine[k++]),
                        Integer.parseInt(inputLine[k++]));
            }
            System.out.println(
                    String.format("%.6f", fractionalKnapsack(w, arr, n)));
        }
    }

    static class Pair {
        int idx;
        double val;

        Pair(int idx, double val){
            this.idx = idx;
            this.val = val;
        }
    }

    // Function to get the maximum total value in the knapsack.
    static double fractionalKnapsack(int w, fractionalKnapsack arr[], int n) {
        double ans = 0;
        Pair[] ar = new Pair[n];
        for(int i=0; i<n; i++) {
            ar[i] = new Pair(i, (double) arr[i].value / arr[i].weight);
        }

        Arrays.sort(ar, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return Double.compare(b.val, a.val);
            }
        });

        for(int i=0; i<n && w>0; i++) {
            int t = ar[i].idx;
            if(arr[t].weight <= w) {
                w -= arr[t].weight;
                ans += arr[t].value;
            } else {
                ans += arr[t].value * ((double)w / arr[t].weight);
                w = 0;
            }
        }
        return ans;
    }
}
