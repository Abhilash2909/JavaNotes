package N3_Sortings.src;

public class selectionSort {
    public static void selectionSort(int n, int[] ar) {
        for(int i=0; i<n-1; i++) {
            int idx = i;
            for(int j=i+1; j<n; j++) {
                if(ar[j] < ar[idx]) {
                    idx = j;
                }
            }
            int temp = ar[idx];
            ar[idx] = ar[i];
            ar[i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] ar = {3, 1, 4, 2, 5};
        selectionSort(5, ar);
        for(int i : ar) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}