package N3_Sortings.src;

public class insertionSort {
    public static void insertionSort(int n, int[] ar) {
        for(int i=1; i<n; i++) {
            int key = ar[i];
            int j = i - 1;
            while (j >= 0 && ar[j] > key) {
                ar[j + 1] = ar[j];
                j--;
            }
            ar[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        int[] ar = {3, 1, 4, 2, 5};
        insertionSort(5, ar);
        for(int i : ar) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}